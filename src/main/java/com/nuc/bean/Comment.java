package com.nuc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {
	private String comment_id;
	private String comment_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date comment_date;
	private String comment_text;
	private Integer comment_status;
	private String comment_order_id;
	private Integer comment_goods_id;

	public Integer getComment_goods_id() {
		return comment_goods_id;
	}

	public void setComment_goods_id(Integer comment_goods_id) {
		this.comment_goods_id = comment_goods_id;
	}

	public String getComment_order_id() {
		return comment_order_id;
	}

	public void setComment_order_id(String comment_order_id) {
		this.comment_order_id = comment_order_id;
	}

	public Integer getComment_status() {
		return comment_status;
	}

	public void setComment_status(Integer comment_status) {
		this.comment_status = comment_status;
	}

	private Integer comment_rate;

	public Integer getComment_rate() {
		return comment_rate;
	}

	public void setComment_rate(Integer comment_rate) {
		this.comment_rate = comment_rate;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_user() {
		return comment_user;
	}

	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

}
