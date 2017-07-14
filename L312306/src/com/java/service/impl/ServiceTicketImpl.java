package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.ITicketDao;
import com.java.service.iservice.ITicketService;

import hibernate.Ticket;

@Service("ticketService")
public class ServiceTicketImpl implements ITicketService {
	@Autowired
	@Qualifier("ticketDao")
	private ITicketDao ticketDao;

	@Transactional
	@Override
	public String save(Ticket t) {
		String msg = "error";
		try {
			List<Ticket> tickets = ticketDao.findByProperty("id", t.getId());
			if (tickets.size() == 0) {
				ticketDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Ticket t) {
		String msg = "error";
		try {
			Ticket e = ticketDao.findById(t.getId());
			if (e != null) {
				ticketDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Ticket newT) {
		String msg = "error";
		try {
			Ticket e = ticketDao.findById(newT.getId());
			if (e != null) {
				ticketDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ticket> findAll() {
		List<Ticket> tickets = null;
		try {
			tickets = ticketDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Transactional(readOnly = true)
	@Override
	public Ticket findById(Integer k) {
		Ticket ticket = null;
		try {
			ticket = ticketDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ticket> findByProperty(String propName, Object propVal) {
		List<Ticket> tickets = null;
		try {
			tickets = ticketDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}

}
