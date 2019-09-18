package com.nuc.bean;

public class Orderitem {
	private String orderitem_id;
	private Integer goods_id;
	private String order_id;
	private Integer goods_amount;

	public String getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}
}
