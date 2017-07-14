package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IJourneyDao;

import hibernate.Journey;
@SuppressWarnings("unchecked")
@Repository("journeyDao")
public class DaoJourneyImpl implements IJourneyDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Journey t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Journey t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Journey newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Journey> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Journey").list();
	}

	@Override
	public Journey findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
		Journey entity = (Journey) session.get(Journey.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Journey> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Journey> journeyList = session.createQuery("from Journey d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return journeyList;
	}

}
