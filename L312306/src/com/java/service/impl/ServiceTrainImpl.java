package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.ITrainDao;
import com.java.service.iservice.ITrainService;

import hibernate.Train;

@Service("trainService")
public class ServiceTrainImpl implements ITrainService {
	@Autowired
	@Qualifier("trainDao")
	private ITrainDao trainDao;

	@Transactional
	@Override
	public String save(Train t) {
		String msg = "error";
		try {
			List<Train> trains = trainDao.findByProperty("id", t.getId());
			if (trains.size() == 0) {
				trainDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Train t) {
		String msg = "error";
		try {
			Train e = trainDao.findById(t.getId());
			if (e != null) {
				trainDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Train newT) {
		String msg = "error";
		try {
			Train e = trainDao.findById(newT.getId());
			if (e != null) {
				trainDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Train> findAll() {
		List<Train> trains = null;
		try {
			trains = trainDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trains;
	}

	@Transactional(readOnly = true)
	@Override
	public Train findById(String k) {
		Train train = null;
		try {
			train = trainDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return train;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Train> findByProperty(String propName, Object propVal) {
		List<Train> trains = null;
		try {
			trains = trainDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trains;
	}



}
