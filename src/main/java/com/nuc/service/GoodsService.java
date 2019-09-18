package com.nuc.service;

import java.util.List;
import java.util.Map;

import com.nuc.bean.Comment;
import com.nuc.bean.Goods;

public interface GoodsService {

	Map<String, List<Goods>> selectAll();

	List<Goods> selectSome(String goodsname);

	List<Comment> selectComment(int comment_goods_id);

	Goods selectOne(int goods_id);

	int addGoods(Goods goods);

	int updateGoodsById(Integer goods_id, Integer goods_amount);

	int deleteGoodsById(Integer goods_id);

	int updateGoodPropertiesById(Goods goods);
}
