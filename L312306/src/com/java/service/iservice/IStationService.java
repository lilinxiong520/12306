package com.java.service.iservice;

import java.util.List;

import hibernate.Station;


public interface IStationService extends IBaseService<Station, String> {
	List<Station> findByProperty(String propName, Object propVal);
}
