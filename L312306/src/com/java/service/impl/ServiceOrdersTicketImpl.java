package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.dao.idao.IOrdersDao;
import com.java.dao.idao.ISeatDao;
import com.java.dao.idao.ITicketDao;
import com.java.service.iservice.IOrdersTicketService;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;

@Service("serviceOrdersTicket")
public class ServiceOrdersTicketImpl implements IOrdersTicketService {
	
	@Autowired
	@Qualifier("ordersDao")
	private IOrdersDao ordersDao;
	
	@Autowired
	@Qualifier("seatDao")
	private ISeatDao seatDao;
	
	@Autowired
	@Qualifier("ticketDao")
	private ITicketDao ticketDao;
	
	
	@Override
	public String ticketOut(int id, int tid) {
		try {
			//修改订单状态
			Orders orders = new Orders();
			orders.setStatus(0);
			ordersDao.update(orders);
			
			//修改坐席状态
			Ticket ticket = ticketDao.findById(tid);
			String propName = "train.id="+ticket.getId()+" and "
					+ "gnumber = "+ticket.getGnumber()+" and "
							+ " startstation = '"+ticket.getStartstation()+"' and "
									+ " endstation ";
			String propVal = ticket.getEndstation();
			List<Seat> seats = seatDao.findByProperty(propName, propVal);
			Seat seat = seats.get(0);
			seatDao.update(seats.get(0));
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
