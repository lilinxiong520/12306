package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IUuserDao;

import hibernate.Uuser;



@Repository("uuserDao")
public class DaoUuserImpl implements IUuserDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public void save(Uuser t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(Uuser newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);
	}
	
	@Override
	public void delete(Uuser t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<Uuser> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Uuser> uuserList = session.createQuery("from Uuser").list();
		 session.clear();
		return uuserList;
	}


	@Override
	public List<Uuser> findByName(String name) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Uuser> uuserList = sessionFactory.getCurrentSession()
				.createQuery("from Uuser d where d.dname like ?")
				.setParameter(0, "%"+name+"%").list();
		 session.clear();
		return uuserList;
	}

	@Override
	public Uuser findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Uuser uuser = (Uuser) sessionFactory.getCurrentSession().get(Uuser.class, k);
		 session.clear();
		return uuser;
	}

	@Override
	public Uuser login(Uuser uuser2) throws Exception {
		List<Uuser> uuser = (List<Uuser>) sessionFactory.getCurrentSession().createQuery("from Uuser a where a.username=? and a.password=?")
		.setParameter(0, uuser2.getUsername())
		.setParameter(1, uuser2.getPassword()).list();
		sessionFactory.getCurrentSession().clear();
		return uuser.get(0);
	}

}
