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

import com.nuc.bean.Comment;
import com.nuc.bean.Goods;
import com.nuc.service.CommentService;
import com.nuc.service.GoodsService;
import com.nuc.util.R;
import com.nuc.util.TimeFormat;
import com.nuc.util.UUIDMachine;

@RequestMapping("/comment")
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private GoodsService GoodsService;

	@RequestMapping(value = "/publishComment", method = RequestMethod.POST)
	@ResponseBody
	public R publishComment(@RequestParam("user_id") String user_id, @RequestParam("order_id") String order_id,
			@RequestParam("food_id") String food_id, @RequestParam("comment_rate") String comment_rate,
			@RequestParam("comment_content") String comment_content) {
		Comment comment = new Comment();
		String id = UUIDMachine.createId();
		comment.setComment_id(id);
		comment.setComment_user(user_id);
		comment.setComment_order_id(order_id);
		comment.setComment_goods_id(Integer.parseInt(food_id));
		Date date = TimeFormat.getDate();
		comment.setComment_date(date);
		comment.setComment_rate(Integer.parseInt(comment_rate));
		comment.setComment_status(1); // 1代表以评论
		int flag = commentService.publishComment(comment);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

	/**
	 * 获取订单中菜品评论
	 * 
	 * @param user_id
	 * @param order_id
	 * @return
	 */
	@RequestMapping(value = "/getOwnComment", method = RequestMethod.POST)
	public List<Map<Object, Object>> getOwnComment(@RequestParam("user_id") String user_id,
			@RequestParam("order_id") String order_id) {
		List<Comment> list = commentService.getOwnComment(user_id, order_id);
		List<Map<Object, Object>> templist = new ArrayList<>();
		if (list != null) {
			for (Comment comment : list) {
				HashMap<Object, Object> tempmap = new HashMap<>();
				Integer goods_id = comment.getComment_goods_id();
				Goods one = GoodsService.selectOne(goods_id);
				String picture_url = one.getGoods_picture();
				tempmap.put("food_id", goods_id);
				tempmap.put("img-src", picture_url);
				tempmap.put("comment_rate", comment.getComment_rate());
				tempmap.put("comment_content", comment.getComment_text());
				tempmap.put("comment_date", comment.getComment_date());
				tempmap.put("comment_status", comment.getComment_status());
				templist.add(tempmap);
			}
			templist.add(R.ok());
			return templist;
		} else {
			templist.add(R.error());
			return templist;
		}
	}
}
