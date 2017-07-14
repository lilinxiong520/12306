package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IPriceDao;
import com.java.service.iservice.IPriceService;

import hibernate.Price;

@Service("priceService")
public class ServicePriceImpl implements IPriceService {
	@Autowired
	@Qualifier("priceDao")
	private IPriceDao priceDao;

	@Transactional
	@Override
	public String save(Price t) {
		String msg = "error";
		try {
			List<Price> prices = priceDao.findByProperty("id", t.getId());
			if (prices.size() == 0) {
				priceDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Price t) {
		String msg = "error";
		try {
			Price e = priceDao.findById(t.getId());
			if (e != null) {
				priceDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Price newT) {
		String msg = "error";
		try {
			Price e = priceDao.findById(newT.getId());
			if (e != null) {
				priceDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Price> findAll() {
		List<Price> prices = null;
		try {
			prices = priceDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prices;
	}

	@Transactional(readOnly = true)
	@Override
	public Price findById(Integer k) {
		Price price = null;
		try {
			price = priceDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Price> findByProperty(String propName, Object propVal) {
		List<Price> prices = null;
		try {
			prices = priceDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prices;
	}

}
