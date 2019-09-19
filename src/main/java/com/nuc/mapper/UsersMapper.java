package com.nuc.mapper;


import com.nuc.bean.Users;

public interface UsersMapper {

	int InsertUsers( Users users);

	Users SelectByUserName(String user_name);
    int updateAddress(Users users);
}
