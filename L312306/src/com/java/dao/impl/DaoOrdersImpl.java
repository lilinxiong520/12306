package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IOrdersDao;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;
@SuppressWarnings("unchecked")
@Repository("ordersDao")
public class DaoOrdersImpl implements IOrdersDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Orders t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);

	}
	
	@Override
	public void delete(Orders t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Orders newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Orders> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Orders").list();
	}

	@Override
	public Orders findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Orders entity = (Orders) session.get(Orders.class, k);
		session.clear();
		return entity;
	}
	
	@Override
	public List<Orders> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		List<Orders> ordersList = session.createQuery("from Orders d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.clear();
		return ordersList;
	}

	@Override
	public void save(Orders t, Ticket ticket, Seat seat) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}


}
