package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IJourneyrateDao;
import com.java.service.iservice.IJourneyrateService;

import hibernate.Journeyrate;

@Service("journeyrateService")
public class ServiceJourneyrateImpl implements IJourneyrateService {
	@Autowired
	@Qualifier("journeyrateDao")
	private IJourneyrateDao journeyrateDao;

	@Transactional
	@Override
	public String save(Journeyrate t) {
		String msg = "error";
		try {
			List<Journeyrate> journeyrates = journeyrateDao.findByProperty("id", t.getId());
			if (journeyrates.size() == 0) {
				journeyrateDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Journeyrate t) {
		String msg = "error";
		try {
			Journeyrate e = journeyrateDao.findById(t.getId());
			if (e != null) {
				journeyrateDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Journeyrate newT) {
		String msg = "error";
		try {
			Journeyrate e = journeyrateDao.findById(newT.getId());
			if (e != null) {
				journeyrateDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Journeyrate> findAll() {
		List<Journeyrate> journeyrates = null;
		try {
			journeyrates = journeyrateDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journeyrates;
	}

	@Transactional(readOnly = true)
	@Override
	public Journeyrate findById(Integer k) {
		Journeyrate journeyrate = null;
		try {
			journeyrate = journeyrateDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journeyrate;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Journeyrate> findByProperty(String propName, Object propVal) {
		List<Journeyrate> journeyrates = null;
		try {
			journeyrates = journeyrateDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journeyrates;
	}

}
