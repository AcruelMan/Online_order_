package com.nuc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nuc.bean.Admin;

public interface AdminMapper {
	@Select("select * from admin where admin_name=#{admin_name}")
	Admin selectAdmin(@Param("admin_name") String admin_name);

	@Insert("insert into admin values (#{admin_id},#{admin_name},#{admin_password})")
	int insertAdmin(@Param("admin") Admin admin);

}
