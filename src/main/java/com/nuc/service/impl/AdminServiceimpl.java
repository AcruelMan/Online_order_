package com.nuc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.bean.Admin;
import com.nuc.mapper.AdminMapper;
import com.nuc.service.AdminService;

@Service
public class AdminServiceimpl implements AdminService {
	@Autowired
	private AdminMapper AdminMapper;

	@Override
	public Admin selectOne(String admin_name) {
		Admin admin = AdminMapper.selectAdmin(admin_name);
		return admin;
	}

	@Override
	public int insertOne(Admin admin) {
		// TODO Auto-generated method stub
		return AdminMapper.insertAdmin(admin);
	}

}
