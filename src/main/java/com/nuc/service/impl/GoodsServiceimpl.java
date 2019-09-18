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

	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.addGoods(goods);
	}

	@Override
	public int updateGoodsById(Integer goods_id, Integer goods_amount) {
		// TODO Auto-generated method stub
		Goods one = goodsMapper.selectOne(goods_id);
		int boughtAmount = one.getGoods_amount();
		int buyingAmount = goods_amount;
		int sum = boughtAmount + buyingAmount;
		Goods goods = new Goods();
		goods.setGoods_id(goods_id);
		goods.setGoods_amount(sum);
		int flag = goodsMapper.updateGoodsById(goods);
		return flag;
	}

	@Override
	public int deleteGoodsById(Integer goods_id) {
		// TODO Auto-generated method stub
		int flag = goodsMapper.deleteGoodByID(goods_id);
		return flag;
	}

	@Override
	public int updateGoodPropertiesById(Goods goods) {
		// TODO Auto-generated method stub
		int flag = goodsMapper.updateGoodPropertiesById(goods);
		return flag;
	}

}
