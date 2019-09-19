package com.nuc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.bean.Users;
import com.nuc.mapper.UsersMapper;
import com.nuc.service.UsersService;

@Service
public class UsersServiceimpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public int insertOneUsers(Users users) {

		return usersMapper.InsertUsers(users);
	}

	public Users selectOne(String user_name) {
		return usersMapper.SelectByUserName(user_name);
	}

	@Override
	public int updateAddress(Users users) {
		// TODO Auto-generated method stub
		int flag = usersMapper.updateAddress(users);
		return flag;
	}

}
