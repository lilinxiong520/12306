package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IPriceDao;

import hibernate.Price;
@SuppressWarnings("unchecked")
@Repository("priceDao")
public class DaoPriceImpl implements IPriceDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Price t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Price t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Price newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Price> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Price").list();
	}

	@Override
	public Price findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
		Price entity = (Price) session.get(Price.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Price> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Price> priceList = session.createQuery("from Price d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return priceList;
	}

}
