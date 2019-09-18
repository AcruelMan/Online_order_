package com.nuc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nuc.bean.Comment;
import com.nuc.bean.Goods;

public interface GoodsMapper {

	List<Goods> selectKind(@Param("catelog_name") String catelog_name);

	List<Goods> selectSome(@Param("goods_name") String goods_name);

	List<Comment> selectComment(@Param("comment_goods_id") Integer comment_goods_id);

	Goods selectOne(@Param("goods_id") Integer goods_id);

	int addGoods(@Param("goods") Goods goods);

	int updateGoodsById(@Param("goods") Goods goods);

	int updateGoodPropertiesById(@Param("goods") Goods goods);

	int deleteGoodByID(@Param("goods") Integer goods);
}
