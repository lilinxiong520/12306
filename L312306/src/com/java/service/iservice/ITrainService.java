package com.java.service.iservice;

import java.util.List;

import hibernate.Train;

public interface ITrainService extends IBaseService<Train, String> {
	List<Train> findByProperty(String propName, Object propVal);
}
