package com.nuc.mapper;

import java.util.List;


import com.nuc.bean.Comment;
import com.nuc.bean.Goods;

public interface GoodsMapper {

	List<Goods> selectKind( String catelog_name);

	List<Goods> selectSome( String goods_name);

	List<Comment> selectComment( Integer comment_goods_id);

	Goods selectOne( Integer goods_id);

	int addGoods( Goods goods);

	int updateGoodsById( Goods goods);

	int updateGoodPropertiesById( Goods goods);

	int deleteGoodByID(Integer goods);
}
