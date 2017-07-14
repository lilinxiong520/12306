package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IJourneyDao;
import com.java.service.iservice.IJourneyService;

import hibernate.Journey;

@Service("journeyService")
public class ServiceJourneyImpl implements IJourneyService {
	@Autowired
	@Qualifier("journeyDao")
	private IJourneyDao journeyDao;

	@Transactional
	@Override
	public String save(Journey t) {
		String msg = "error";
		try {
			List<Journey> journeys = journeyDao.findByProperty("id", t.getId());
			if (journeys.size() == 0) {
				journeyDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Journey t) {
		String msg = "error";
		try {
			Journey e = journeyDao.findById(t.getId());
			if (e != null) {
				journeyDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Journey newT) {
		String msg = "error";
		try {
			Journey e = journeyDao.findById(newT.getId());
			if (e != null) {
				journeyDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Journey> findAll() {
		List<Journey> journeys = null;
		try {
			journeys = journeyDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journeys;
	}

	@Transactional(readOnly = true)
	@Override
	public Journey findById(Integer k) {
		Journey journey = null;
		try {
			journey = journeyDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journey;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Journey> findByProperty(String propName, Object propVal) {
		List<Journey> journeys = null;
		try {
			journeys = journeyDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journeys;
	}

}
