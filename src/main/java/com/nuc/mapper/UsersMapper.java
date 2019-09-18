package com.nuc.mapper;

import org.apache.ibatis.annotations.Param;

import com.nuc.bean.Users;

public interface UsersMapper {

	int InsertUsers(@Param("users") Users users);

	Users SelectByUserName(@Param("user_name") String user_name);
}
