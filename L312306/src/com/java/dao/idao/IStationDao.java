package com.java.dao.idao;

import java.util.List;

import hibernate.Station;

public interface IStationDao extends IBaseDao<Station, String> {
	List<Station> findByProperty(String propName, Object propVal)throws Exception;
}
