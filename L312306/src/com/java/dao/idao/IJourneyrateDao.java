package com.java.dao.idao;

import java.util.List;

import hibernate.Journeyrate;

public interface IJourneyrateDao extends IBaseDao<Journeyrate, Integer> {
	List<Journeyrate> findByProperty(String propName, Object propVal)throws Exception;
}
