package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IPlanDao;

import hibernate.Plan;

@SuppressWarnings("unchecked")
@Repository("planDao")
public class DaoPlanImpl implements IPlanDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Plan t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Plan t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Plan newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Plan> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Plan").list();
	}

	@Override
	public Plan findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
		Plan entity = (Plan) session.get(Plan.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Plan> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Plan> planList = session.createQuery("from Plan d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return planList;
	}

}
