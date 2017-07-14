package com.java.service.iservice;

import java.util.List;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;

public interface IOrdersService extends IBaseService<Orders, Integer> {
	List<Orders> findByProperty(String propName, Object propVal);
	
	String save(Orders t,Ticket ticket,Seat seat);
}
