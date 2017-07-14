package com.java.dao.idao;

import java.util.List;

import hibernate.Carriage;

public interface ICarriageDao extends IBaseDao<Carriage, Integer> {
	List<Carriage> findByProperty(String propName, Object propVal)throws Exception;
}
