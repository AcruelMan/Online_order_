package com.nuc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.bean.Order;
import com.nuc.bean.Orderitem;

import com.nuc.mapper.OrderItemMapper;
import com.nuc.mapper.OrderMapper;
import com.nuc.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {
	@Autowired
	private OrderMapper OrderMapper;
	@Autowired
	private OrderItemMapper OrderItemMapper;

	@Override
	public int OrderCommit(Order order) {
		int result = OrderMapper.insertOrder(order);
		return result;
	}

	@Override
	public int selectAll(String user_id) {
		// TODO Auto-generated method stub
		int total = OrderMapper.selectAll(user_id);
		return total;
	}

	@Override
	public List<Order> selectList(String user_id, Integer start, Integer end) {
		// TODO Auto-generated method stub
		List<Order> selectUserList = OrderMapper.selectUserList(user_id, start, end);
		return selectUserList;
	}

	public List<Orderitem> selcetOrderItem(String order_id) {
		return OrderItemMapper.selcetOrderItem(order_id);
	}

	@Override
	public Order selectOne(String order_id) {
		// TODO Auto-generated method stub
		return OrderMapper.selectOne(order_id);
	}

	

}
