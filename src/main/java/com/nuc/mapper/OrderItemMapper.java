package com.nuc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nuc.bean.Orderitem;

public interface OrderItemMapper {

	List<Orderitem> selcetOrderItem(@Param("order_id") String order_id);

	int insertOne(@Param("orderitem") Orderitem orderitem);
}
