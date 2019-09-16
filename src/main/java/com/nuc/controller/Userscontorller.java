package com.nuc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public R register(@RequestParam("username") String user_name, @RequestParam("pwd") String user_password,
			@RequestParam("sex") int user_sex, @RequestParam("age") int user_age, @RequestParam("tel") String tel,
			@RequestParam("email") String email) {
		Users users = new Users();
		String tempId = UUIDMachine.createOrderId();
		String user_pwd = MD5Machine.stringToMD5(user_password);
		users.setUser_id(tempId);
		users.setUser_name(user_name);
		users.setUser_password(user_pwd);
		users.setUser_sex(user_sex);
		users.setUser_age(user_age);
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
	@RequestMapping(value = "isExist", method = RequestMethod.GET)
	public R isExist(@RequestParam("username") String username) {
		Users users = userService.selectOne(username);
		if (users != null) {
			return R.error();
		} else {
			return R.ok();
		}

	}

}
