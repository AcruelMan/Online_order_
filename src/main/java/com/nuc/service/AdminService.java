package com.nuc.service;

import com.nuc.bean.Admin;

public interface AdminService {
	Admin selectOne(String admin_name);

	int insertOne(Admin admin);
}
