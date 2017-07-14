package com.java.dao.idao;

import java.util.List;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;

public interface IOrdersDao extends IBaseDao<Orders, Integer> {
	List<Orders> findByProperty(String propName, Object propVal)throws Exception;

	void save(Orders t, Ticket ticket, Seat seat) throws Exception;
}
