package com.nuc.util;

import java.util.HashMap;

public class R extends HashMap<Object, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static R ok() { // 200代表成功
		R r = new R();
		r.put("code", "200");
		r.put("message", "成功");
		return r;

	}

	public static R error() { // 500代表错误
		R r = new R();
		r.put("code", "500");
		r.put("message", "失败");
		return r;

	}

	public static R ok(String message) {
		R r = new R();
		r.put("code", "200");
		r.put("message", message);
		return r;

	}

	public static R error(String message) {
		R r = new R();
		r.put("code", "500");
		r.put("message", message);
		return r;

	}

	public R put(String k, String v) {
		super.put(k, v);
		return this;
	}
}