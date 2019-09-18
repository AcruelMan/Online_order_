package com.nuc.service;

import java.util.List;

import com.nuc.bean.Order;
import com.nuc.bean.Orderitem;

public interface OrderService {
	int OrderCommit(Order order);

	int selectAll(String user_id);

	List<Order> selectList(String user_id, Integer start, Integer end);

	List<Orderitem> selcetOrderItem(String order_id);

	Order selectOne(String order_id);

	int insertOrderItem(Orderitem orderitem);

}
