package com.java.service.iservice;

import com.java.dao.pojo.OrdersVo;

public interface IOrdersVoService{


	OrdersVo findByInfo(int idnumber);
	
}
