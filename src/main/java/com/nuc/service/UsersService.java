package com.nuc.service;

import com.nuc.bean.Users;

public interface UsersService {
	int insertOneUsers(Users users);

	Users selectOne(String user_name);
}
