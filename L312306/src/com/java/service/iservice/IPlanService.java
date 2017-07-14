package com.java.service.iservice;

import java.util.List;

import hibernate.Plan;

public interface IPlanService extends IBaseService<Plan, Integer> {
	List<Plan> findByProperty(String propName, Object propVal);
}
