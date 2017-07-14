package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IPlanDao;
import com.java.service.iservice.IPlanService;

import hibernate.Plan;

@Service("planService")
public class ServicePlanImpl implements IPlanService {
	@Autowired
	@Qualifier("planDao")
	private IPlanDao planDao;

	@Transactional
	@Override
	public String save(Plan t) {
		String msg = "error";
		try {
			List<Plan> plans = planDao.findByProperty("id", t.getId());
			if (plans.size() == 0) {
				planDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Plan t) {
		String msg = "error";
		try {
			Plan e = planDao.findById(t.getId());
			if (e != null) {
				planDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Plan newT) {
		String msg = "error";
		try {
			Plan e = planDao.findById(newT.getId());
			if (e != null) {
				planDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plan> findAll() {
		List<Plan> plans = null;
		try {
			plans = planDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plans;
	}

	@Transactional(readOnly = true)
	@Override
	public Plan findById(Integer k) {
		Plan plan = null;
		try {
			plan = planDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plan> findByProperty(String propName, Object propVal) {
		List<Plan> plans = null;
		try {
			plans = planDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plans;
	}

	



}
