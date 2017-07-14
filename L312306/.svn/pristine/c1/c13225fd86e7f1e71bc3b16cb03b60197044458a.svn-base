package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IOrdersDao;
import com.java.dao.idao.ISeatDao;
import com.java.dao.idao.ITicketDao;
import com.java.service.iservice.IOrdersService;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;

@Service("ordersService")
public class ServiceOrdersImpl implements IOrdersService {
	@Autowired
	@Qualifier("ordersDao")
	private IOrdersDao ordersDao;
	
	@Autowired
	@Qualifier("ticketDao")
	private ITicketDao ticketDao;
	
	
	@Autowired
	@Qualifier("seatDao")
	private ISeatDao seatDao;

	@Transactional
	@Override
	public String save(Orders t) {
		String msg = "error";
		try {
			List<Orders> orderss = ordersDao.findByProperty("id", t.getId());
			if (orderss.size() == 0) {
				ordersDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@Transactional
	@Override
	public String save(Orders t,Ticket ticket,Seat seat) {
		String msg = "error";
		try {
		//分别生产车票   坐席  订单
		ticketDao.save(ticket);
		seatDao.save(seat);
		ordersDao.save(t,ticket,seat);
		
		msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	
	@Transactional
	@Override
	public String delete(Orders t) {
		String msg = "error";
		try {
			Orders e = ordersDao.findById(t.getId());
			if (e != null) {
				ordersDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Orders newT) {
		String msg = "error";
		try {
			Orders e = ordersDao.findById(newT.getId());
			if (e != null) {
				ordersDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Orders> findAll() {
		List<Orders> orderss = null;
		try {
			orderss = ordersDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderss;
	}

	@Transactional(readOnly = true)
	@Override
	public Orders findById(Integer k) {
		Orders orders = null;
		try {
			orders = ordersDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Orders> findByProperty(String propName, Object propVal) {
		List<Orders> orderss = null;
		try {
			orderss = ordersDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderss;
	}
	

}
