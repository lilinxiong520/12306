package com.java.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.ISeatDao;
import com.java.service.iservice.IComputeSeatService;

@Service("serviceComputeSeat")
public class ServiceComputeSeatImpl implements IComputeSeatService {
	
	
	@Autowired
	@Qualifier("seatDao")
	private ISeatDao seatDao;
	
	@Transactional
	@Override
	public Map<String, Integer> getSeat(String tid, String starStation, String endStation, Date time) {
		Map<String, Integer> map = new HashMap<>();
		//seatDao.findByProperty(propName, propVal);  //查看本次航线所有已购买的车票
		
		return map;
	}

}
