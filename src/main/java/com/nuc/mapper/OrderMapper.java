package com.nuc.mapper;

import java.util.List;

import com.nuc.bean.Order;

public interface OrderMapper {
	int insertOrder(Order order);

	int selectAll(String user_id);

	List<Order> selectUserList(String user_id, Integer start, Integer end);

	Order selectOne(String order_id);

}
