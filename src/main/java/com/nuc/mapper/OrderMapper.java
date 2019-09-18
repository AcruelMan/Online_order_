package com.nuc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nuc.bean.Order;

public interface OrderMapper {
	int insertOrder(@Param("order") Order order);

	int selectAll(@Param("user_id") String user_id);

	List<Order> selectUserList(@Param("user_id") String user_id, @Param("start") Integer start,
			@Param("end") Integer end);

	Order selectOne(@Param("order_id") String order_id);

}
