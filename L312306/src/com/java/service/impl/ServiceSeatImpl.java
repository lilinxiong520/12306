package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.ISeatDao;
import com.java.service.iservice.ISeatService;

import hibernate.Seat;

@Service("seatService")
public class ServiceSeatImpl implements ISeatService {
	@Autowired
	@Qualifier("seatDao")
	private ISeatDao seatDao;

	@Transactional
	@Override
	public String save(Seat t) {
		String msg = "error";
		try {
			List<Seat> seats = seatDao.findByProperty("id", t.getId());
			if (seats.size() == 0) {
				seatDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Seat t) {
		String msg = "error";
		try {
			Seat e = seatDao.findById(t.getId());
			if (e != null) {
				seatDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Seat newT) {
		String msg = "error";
		try {
			Seat e = seatDao.findById(newT.getId());
			if (e != null) {
				seatDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Seat> findAll() {
		List<Seat> seats = null;
		try {
			seats = seatDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seats;
	}

	@Transactional(readOnly = true)
	@Override
	public Seat findById(Integer k) {
		Seat seat = null;
		try {
			seat = seatDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seat;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Seat> findByProperty(String propName, Object propVal) {
		List<Seat> seats = null;
		try {
			seats = seatDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seats;
	}

}
