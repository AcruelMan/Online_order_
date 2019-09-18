package com.nuc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.bean.Goods;
import com.nuc.bean.Order;
import com.nuc.bean.Orderitem;
import com.nuc.service.GoodsService;
import com.nuc.service.OrderService;

import com.nuc.util.R;
import com.nuc.util.TimeFormat;
import com.nuc.util.UUIDMachine;

@RequestMapping("/order")
@Controller
public class OrserController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService GoodsService;

	/**
	 * 提交订单
	 * 
	 * @param order_user_id
	 * @param order_destination
	 * @param order_pay_method
	 * @param order_money
	 * @return
	 */
	@RequestMapping(value = "/commitOrder", method = RequestMethod.POST)
	@ResponseBody
	public R commitOrder(@RequestParam("order_user_id") String order_user_id,
			@RequestParam("order_destination") String order_destination,
			@RequestParam("order_pay_method") String order_pay_method, @RequestParam("order_money") String order_money,
			@RequestParam("food") String food) {
		String order_id = UUIDMachine.createId();
		Date order_date = TimeFormat.getDate();
		int pay_method = Integer.parseInt(order_pay_method);
		int money = Integer.parseInt(order_money);
		Order order = new Order();
		order.setOrder_id(order_id);
		order.setOrder_date(order_date);
		order.setOrder_destination(order_destination);
		order.setOrder_pay_method(pay_method);
		order.setOrder_money(money);
		order.setOrder_user_id(order_user_id);
		order.setOrder_status(1); // 1代表已付钱
		String[] foodIdAndAmount = food.split(",");

		for (String temp : foodIdAndAmount) {
			String[] OrderItem = temp.split(":");
			String id = UUIDMachine.createId();
			Orderitem oItem = new Orderitem();
			oItem.setOrderitem_id(id);
			oItem.setOrder_id(order_id);
			int goods_id = Integer.parseInt(OrderItem[0]);
			int goods_amount = Integer.parseInt(OrderItem[1]);
			int tempFlag = GoodsService.updateGoodsById(goods_id, goods_amount);
			oItem.setGoods_id(goods_id);
			oItem.setGoods_id(goods_id);
			oItem.setGoods_amount(goods_amount);
			int result = orderService.insertOrderItem(oItem);
			if (result > 0 && tempFlag > 0) {
				continue;
			} else {
				return R.error();
			}
		}
		int flag = orderService.OrderCommit(order);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

	/**
	 * 返回此用户订单总条数
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody
	public int total(@RequestParam("order_user_id") String user_id) {
		int total = orderService.selectAll(user_id);
		return total;
	}

	@RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
	@ResponseBody
	public Map<Object, Object> getOrderList(@RequestParam("order_user_id") String user_id,
			@RequestParam("current_page") Integer currentpage) {
		int start = 5 * currentpage - 5;
		int end = 5 * currentpage;
		List<Order> selectList = orderService.selectList(user_id, start, end);
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (selectList != null) {
			map.put("code", "200");
			int i = 0;
			for (Order order : selectList) {
				ArrayList<String> imgList = new ArrayList<>();
				List<Orderitem> selcetOrderItem = orderService.selcetOrderItem(order.getOrder_id()); // 根据order——id找orderitem

				for (Orderitem orderitem : selcetOrderItem) {
					Goods goods = GoodsService.selectOne(orderitem.getGoods_id());// 根据orderitem找goods_id
					imgList.add(goods.getGoods_picture());
				}
				map.put("order" + (i + 1), order);
				map.put("img_src" + (i + 1), imgList);
				i++;
			}

		} else {
			map.put("code", "500");
		}
		return map;
	}

	@RequestMapping(value = "/OrderDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<Object, Object> getOrderDetail(@RequestParam("order_id") String order_id) {
		List<Orderitem> list = orderService.selcetOrderItem(order_id);
		List<Goods> goodslist = new ArrayList<>();
		HashMap<Object, Object> map = new HashMap<>();
		if (list != null && goodslist != null) {
			int i = 0;
			for (Orderitem orderitem : list) {
				Goods goods = GoodsService.selectOne(orderitem.getGoods_id());
				goodslist.add(goods);
				map.put("good" + i, goods);
				i++;
			}
			Order order = orderService.selectOne(order_id);
			map.put("order", order);
			map.put("code", "200");
		} else {
			map.put("code", "500");
		}
		return map;
	}
}
