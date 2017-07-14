package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.ITrainDao;

import hibernate.Train;
@SuppressWarnings("unchecked")
@Repository("trainDao")
public class DaoTrainImpl implements ITrainDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Train t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Train t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Train newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Train> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Train").list();
	}

	@Override
	public Train findById(String k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Train entity = (Train) session.get(Train.class, k);
		session.clear();
		return entity;
	}

	@Override
	public List<Train> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Train> trainList = session.createQuery("from Train d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return trainList;
	}



}
