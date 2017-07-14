package com.java.service.iservice;

import java.util.List;

import hibernate.Admin;


public interface IAdminService extends IBaseService<Admin, Integer> {
	 List<Admin> findByName(String name);

	Admin login(Admin admin2);
	 
}
