package com.java.dao.idao;

import java.util.List;

import hibernate.Route;

public interface IRouteDao extends IBaseDao<Route, Integer> {
	
	List<Route> findByProperty(String propName, Object propVal)throws Exception;

	List<Object[]> findByStationInfo(String fromStation, String toStation) throws Exception;

	List<Object[]> findByIdStationInfo(String fromStation, String toStation, String tid) throws Exception;
	
	
}
