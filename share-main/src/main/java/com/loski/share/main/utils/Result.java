package com.loski.share.main.utils;

import java.util.HashMap;

public class Result extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -626498138347010877L;

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static Result ok(String msg){
		Result r = new Result();
		r.put("msg", msg);
		r.put("status", true);
		return r;
	}

	public static Result ok() {
		Result r = new Result();
		r.put("status", true);
		r.put("msg", "success");
		return r;
	}
}
