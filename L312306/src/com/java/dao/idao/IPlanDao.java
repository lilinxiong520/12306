package com.java.dao.idao;

import java.util.List;

import hibernate.Plan;

public interface IPlanDao extends IBaseDao<Plan, Integer> {
	List<Plan> findByProperty(String propName, Object propVal)throws Exception;
}
