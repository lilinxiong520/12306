package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.IAdminService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Admin;

@Scope("prototype")
@Controller("adminAction")
public class AdminAction implements ModelDriven<Admin>,RequestAware,SessionAware{
	//1.取值
	Admin admin2 = new Admin();
	Map<String, Object> requestMap;
	//解耦合
	@Override
	public Admin getModel() {
		return admin2;
	}
	@Override
	public void setRequest(Map<String, Object> requst) {
		
		requestMap = requst;
	}
	
	private String type1;
	
	//2处理业务逻辑，注入Service层对象
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	public AdminAction() {
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	
	public String save(){
		
		System.out.println(admin2.toString());
		
		return adminService.save(admin2);
	}
	public String delete(){
		
		return adminService.delete(admin2);
	}
	
	public String findAll(){
		String msg = "error";
		System.out.println("***************************************");
		List<Admin> adminList = adminService.findAll();
		if(adminList != null && adminList.size() > 0){
			requestMap.put("adminListFromService", adminList);
			msg = "success";
		}
		return msg;
	}
	
	Map<String, Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap  = session;
		
	}
	public String findById(){
		String msg = "error";
		Admin admin = adminService.findById(admin2.getId());
		if(admin != null){
			System.out.println(type1);
			if("update".equals(type1)){
				requestMap.put("adminFromService", admin);
				msg = "updatesuccess";
			}else{
				List<Admin> adminList = new ArrayList<>();
				adminList.add(admin);
				requestMap.put("adminListFromService", adminList);
				msg = "success";
			}
		}
		return msg;
	}
	
	public String findByName(){
		String msg = "error";
		List<Admin> adminList = adminService.findByName(admin2.getUsername());
		if(adminList != null && adminList.size() > 0){
			requestMap.put("adminListFromService", adminList);
			msg = "success";
		}
		return msg;
	}	
	
	public String update(){
		return adminService.update(admin2);
	}
	
	public String login(){
		String msg = "error";
		Admin admin = adminService.login(admin2);
		if(admin!=null){
			System.out.println(admin.getName());
			sessionMap.put("admin", admin);
			msg ="success";
		}
		return msg;
	}
}
