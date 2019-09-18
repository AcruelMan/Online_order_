package com.nuc.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.bean.Catelog;
import com.nuc.bean.Comment;
import com.nuc.bean.Goods;
import com.nuc.mapper.CatelogMapper;
import com.nuc.mapper.GoodsMapper;
import com.nuc.service.GoodsService;

@Service
public class GoodsServiceimpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CatelogMapper catelogMapper;

	@Override
	public Map<String, List<Goods>> selectAll() {

		List<Catelog> list = catelogMapper.selcetAll();
		HashMap<String, List<Goods>> result = new HashMap<>();
		for (Catelog catelog : list) {
			String catelog_name = catelog.getCatelog_name();
			List<Goods> kindFoods = goodsMapper.selectKind(catelog_name);
			result.put(catelog_name, kindFoods);
		}

		return result;
	}

	@Override
	public List<Goods> selectSome(String goodsname) {
		List<Goods> result = goodsMapper.selectSome(goodsname);
		return result;
	}

	public List<Comment> selectComment(int comment_goods_id) {
		List<Comment> comment = goodsMapper.selectComment(comment_goods_id);
		return comment;
	}

	@Override
	public Goods selectOne(int goods_id) {
		// TODO Auto-generated method stub
		return goodsMapper.selectOne(goods_id);
	}
}
