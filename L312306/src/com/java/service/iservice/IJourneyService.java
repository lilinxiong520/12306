package com.java.service.iservice;

import java.util.List;

import hibernate.Journey;

public interface IJourneyService extends IBaseService<Journey, Integer> {
	List<Journey> findByProperty(String propName, Object propVal);
}
