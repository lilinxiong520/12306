package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IJourneyrateDao;

import hibernate.Journeyrate;
@SuppressWarnings("unchecked")
@Repository("journeyrateDao")
public class DaoJourneyrateImpl implements IJourneyrateDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Journeyrate t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Journeyrate t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Journeyrate newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Journeyrate> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Journeyrate").list();
	}

	@Override
	public Journeyrate findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Journeyrate entity = (Journeyrate) session.get(Journeyrate.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Journeyrate> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Journeyrate> journeyrateList = session.createQuery("from Journeyrate d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return journeyrateList;
	}

}
