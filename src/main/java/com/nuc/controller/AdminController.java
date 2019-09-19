package com.nuc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.bean.Admin;
import com.nuc.bean.Goods;
import com.nuc.service.AdminService;
import com.nuc.service.GoodsService;
import com.nuc.util.MD5Machine;
import com.nuc.util.R;
import com.nuc.util.UUIDMachine;

@RequestMapping("/admin")
@Controller

public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private GoodsService GoodsService;

	/**
	 * 增加管理员
	 * 
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	@RequestMapping(value = "/addOne", method = RequestMethod.POST)
	@ResponseBody
	public R addOne(@RequestParam("admin_name") String admin_name,
			@RequestParam("admin_password") String admin_password) {
		Admin admin = new Admin();
		String id = UUIDMachine.createId();
		String toMD5 = MD5Machine.stringToMD5(admin_password);
		admin.setAdmin_id(id);
		admin.setAdmin_name(admin_name);
		admin.setAdmin_password(toMD5);
		int flag = adminService.insertOne(admin);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

	/**
	 * 登录
	 * 
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public R login(String admin_name, String admin_password) {
		Admin one = adminService.selectOne(admin_name);
		String toMD5 = MD5Machine.stringToMD5(admin_password);
		if (toMD5.equals(one.getAdmin_password())) {
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 增加菜
	 * 
	 * @param goods_catelog_id
	 * @param goods_name
	 * @param goods_discription
	 * @param goods_picture
	 * @param goods_amount
	 * @return
	 */
	@RequestMapping(value = "/addFood", method = RequestMethod.GET)
	@ResponseBody
	public R addfood(Integer goods_catelog_id, String goods_name, String goods_discription, String goods_picture,
			String goods_amount) {
		Goods goods = new Goods();
		goods.setGoods_catelog_id(goods_catelog_id);
		goods.setGoods_name(goods_name);
		goods.setGoods_discription(goods_discription);
		goods.setGoods_discription(goods_discription);
		goods.setGoods_picture(goods_picture);
		goods.setGoods_amount(0);
		int flag = GoodsService.addGoods(goods);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

	/**
	 * 删除多个菜
	 * 
	 * @param goods_id
	 * @return
	 */
	@RequestMapping(value = "/deleteGoodsById", method = RequestMethod.GET)
	@ResponseBody
	public R deleteGoodsById(String goods_id) {
		String[] split = goods_id.split(",");
		for (int i = 0; i < split.length; i++) {
			int tempInt = Integer.parseInt(split[i]);
			int flag = GoodsService.deleteGoodsById(tempInt);
			if (flag > 0) {
				continue;
			} else {
				return R.error();
			}
		}
		return R.ok();
	}

	/**
	 * 更新菜的信息
	 * 
	 * @param goods_id
	 * @param goods_catelog_id
	 * @param goods_name
	 * @param goods_discription
	 * @param goods_picture
	 * @param goods_price
	 * @return
	 */
	@RequestMapping(value = "/updateGoodPropertiesById", method = RequestMethod.GET)
	@ResponseBody
	public R updateGoodPropertiesById(String goods_id, String goods_catelog_id, String goods_name,
			String goods_discription, String goods_picture, String goods_price) {
		Goods goods = new Goods();
		goods.setGoods_id(Integer.parseInt(goods_id));
		goods.setGoods_catelog_id(Integer.parseInt(goods_catelog_id));
		goods.setGoods_name(goods_name);
		goods.setGoods_discription(goods_discription);
		goods.setGoods_picture(goods_picture);
		goods.setGoods_price(Integer.parseInt(goods_price));
		int flag = GoodsService.updateGoodPropertiesById(goods);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

}
