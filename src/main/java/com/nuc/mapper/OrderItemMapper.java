package com.nuc.mapper;

import java.util.List;



import com.nuc.bean.Orderitem;

public interface OrderItemMapper {

	List<Orderitem> selcetOrderItem( String order_id);

	int insertOne( Orderitem orderitem);
}
