package com.nuc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.bean.Users;
import com.nuc.service.UsersService;
import com.nuc.util.MD5Machine;
import com.nuc.util.R;
import com.nuc.util.UUIDMachine;

@RequestMapping("/users")
@Controller
public class Userscontorller {

	@Autowired
	private UsersService userService;

	/**
	 * 登录操作
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public R login(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
		Users users = userService.selectOne(username);
		String md5pwd = MD5Machine.stringToMD5(pwd);
		boolean flag = users.getUser_password() == md5pwd;
		if (flag) {
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 注册客户
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_sex
	 * @param user_age
	 * @param tel
	 * @param email
	 * @return
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public R register(@RequestParam("username") String user_name, @RequestParam("pwd") String user_password,
			@RequestParam("sex") String user_sex, @RequestParam("age") String user_age, @RequestParam("tel") String tel,
			@RequestParam("email") String email) {
		System.out.print(user_name);
		Users users = new Users();
		String tempId = UUIDMachine.createId();// 生成ID
		String user_pwd = MD5Machine.stringToMD5(user_password);
		users.setUser_id(tempId);
		users.setUser_name(user_name);
		users.setUser_password(user_pwd);
		users.setUser_sex(Integer.parseInt(user_sex));
		users.setUser_age(Integer.parseInt(user_age));
		users.setUser_tel(tel);
		users.setUser_email(email);

		int flag = userService.insertOneUsers(users);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}

	}

	/**
	 * 用于注册时判断是否存在用户
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/isExist", method = RequestMethod.POST)
	@ResponseBody
	public R isExist(@RequestParam("username") String username) {
		System.out.println(username);
		Users users = userService.selectOne(username);
		if (users != null) {
			return R.error();
		} else {
			return R.ok();
		}

	}

	/**
	 * 获取用户信息
	 * 
	 * @param use_name
	 * @return
	 */
	public List<Map<Object, Object>> getUserInfo(String use_name) {
		ArrayList<Map<Object, Object>> list = new ArrayList<>();
		Users one = userService.selectOne(use_name);
		HashMap<Object, Object> map = new HashMap<>();
		if (one != null) {
			map.put("code", "200");
			map.put("", one.getUser_id());
			map.put("user_address", one.getUser_address());
			map.put("user_sex", one.getUser_sex());
			map.put("user_tel", one.getUser_tel());
			map.put("user_email", one.getUser_email());
			map.put("user_age", one.getUser_age());
			list.add(map);
			return list;
		} else {
			list.add(R.error());
			return list;
		}

	}

	/**
	 * 修改地址
	 * 
	 * @param user_id
	 * @param user_addrss
	 * @return
	 */
	public R updateAddress(String user_id, String user_addrss) {
		Users users = new Users();
		users.setUser_id(user_id);
		users.setUser_address(user_addrss);
		int flag = userService.updateAddress(users);
		if (flag > 0) {
			return R.ok();
		} else {
			return R.error();
		}
	}
}
