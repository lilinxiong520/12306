package com.java.service.iservice;

import java.util.Date;
import java.util.Map;

public interface IComputeSeatService {
	public Map<String, Integer> getSeat(String tid,String starStation,String endStation,Date time);

}
