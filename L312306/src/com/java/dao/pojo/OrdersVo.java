package com.java.dao.pojo;

import java.io.Serializable;

import hibernate.Orders;
import hibernate.Route;
import hibernate.Ticket;
import hibernate.Train;

public class OrdersVo implements Serializable{

	private Ticket ticket;
	private Orders orders;
	private Train train;
	private Route startRoute;
	private Route endRoute;
	
	private String startTime;  //发车时间
	private String endTime;    //结束时间
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Route getStartRoute() {
		return startRoute;
	}
	public void setStartRoute(Route startRoute) {
		this.startRoute = startRoute;
	}
	public Route getEndRoute() {
		return endRoute;
	}
	public void setEndRoute(Route endRoute) {
		this.endRoute = endRoute;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public OrdersVo(Ticket ticket, Orders orders, Train train, Route startRoute, Route endRoute) {
		super();
		this.ticket = ticket;
		this.orders = orders;
		this.train = train;
		this.startRoute = startRoute;
		this.endRoute = endRoute;
	}
	
	public OrdersVo() {
		
	}
	@Override
	public String toString() {
		return "OrdersVo [ticket=" + ticket + ", orders=" + orders + ", train=" + train + ", startRoute=" + startRoute
				+ ", endRoute=" + endRoute + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
