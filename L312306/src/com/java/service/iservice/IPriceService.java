package com.java.service.iservice;

import java.util.List;

import hibernate.Price;

public interface IPriceService extends IBaseService<Price, Integer> {
	List<Price> findByProperty(String propName, Object propVal);
}
