package com.nuc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nuc.bean.Comment;
import com.nuc.bean.Goods;
import com.nuc.service.GoodsService;

@RequestMapping("/goods")
@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodService;

	/**
	 * 按菜系返回所有菜
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selcetAll", method = RequestMethod.GET)
	public Map<String, List<Goods>> selectAll() {
		Map<String, List<Goods>> result = goodService.selectAll();
		return result;
	}

	/**
	 * 模糊查询菜
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/selcetSome", method = RequestMethod.GET)
	public List<Goods> selectSome(@RequestParam("name") String name) {
		List<Goods> selectSome = goodService.selectSome(name);
		return selectSome;
	}

	/**
	 * 按照菜品id查找这个菜的评论
	 * 
	 * @param food_id
	 * @return
	 */
	@RequestMapping(value = "/selcetComment", method = RequestMethod.GET)
	public List<Comment> selectComment(@RequestParam("String food_id") String food_id) {
		int id = Integer.parseInt(food_id);
		List<Comment> comment = goodService.selectComment(id);
		return comment;
	}
}
