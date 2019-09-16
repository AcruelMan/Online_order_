package com.nuc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	private Integer order_id;
	private String order_number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date order_date;
	private String order_destination;
	private Integer order_pay_method;
	private Integer order_money;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_destination() {
		return order_destination;
	}

	public void setOrder_destination(String order_destination) {
		this.order_destination = order_destination;
	}

	public Integer getOrder_pay_method() {
		return order_pay_method;
	}

	public void setOrder_pay_method(Integer order_pay_method) {
		this.order_pay_method = order_pay_method;
	}

	public Integer getOrder_money() {
		return order_money;
	}

	public void setOrder_money(Integer order_money) {
		this.order_money = order_money;
	}

	public String getOrder_user_id() {
		return order_user_id;
	}

	public void setOrder_user_id(String order_user_id) {
		this.order_user_id = order_user_id;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	private String order_user_id;
	private Integer order_status;
}
