package com.java.service.iservice;

import java.util.List;

import hibernate.Ticket;

public interface ITicketService extends IBaseService<Ticket, Integer> {
	List<Ticket> findByProperty(String propName, Object propVal);
}
