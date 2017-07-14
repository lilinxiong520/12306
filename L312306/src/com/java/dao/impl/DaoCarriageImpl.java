package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.ICarriageDao;

import hibernate.Carriage;

@SuppressWarnings("unchecked")
@Repository("carriageDao")
public class DaoCarriageImpl implements ICarriageDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Carriage t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Carriage t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Carriage newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Carriage> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Carriage").list();
	}

	@Override
	public Carriage findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
		Carriage entity = (Carriage) session.get(Carriage.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Carriage> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Carriage> carriageList = session.createQuery("from Carriage d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return carriageList;
	}

}
