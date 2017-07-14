package com.java.service.iservice;

import java.util.List;

import hibernate.Seat;

public interface ISeatService extends IBaseService<Seat, Integer> {
	List<Seat> findByProperty(String propName, Object propVal);
}
