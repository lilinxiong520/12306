package com.java.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.dao.pojo.OrdersVo;
import com.java.dao.pojo.RouteInfo;
import com.java.service.iservice.IOrdersService;
import com.java.service.iservice.IOrdersVoService;
import com.java.service.iservice.IRouteService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Orders;
import hibernate.Seat;
import hibernate.Ticket;
import hibernate.Train;
import hibernate.Uuser;

@Controller("ordersVoAction")
@Scope("prototype")
public class OrdersVoAction  implements RequestAware,SessionAware,ModelDriven<OrdersVo> {
	
	//取值
	private Map<String,Object> sessionMap;
	private Map<String,Object> requstMap;
	private int id;
	private OrdersVo ordersVo = new OrdersVo();
	private String seat;
	
	@Override
	public OrdersVo getModel() {
		return ordersVo;
	}
	
	//注入service层
	@Autowired
	@Qualifier("ordersVoService")
	private IOrdersVoService ordersVoService;
	
	@Autowired
	@Qualifier("ordersService")
	private IOrdersService ordersService;
	
	@Autowired
	@Qualifier("routeService")
	private IRouteService routeService;
	
	@Override
	public void setRequest(Map<String, Object> requstMap) {
		this.requstMap = requstMap;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	//生成订单 以及火车票
	public String save() {
		String msg = "error";
		Uuser uuser = (Uuser) sessionMap.get("uuser");
		if(uuser == null){
			return msg;
		}
		//生成订单
		//1.生成车票  
		Ticket ticket = ordersVo.getTicket();
		Train train = ordersVo.getTrain();
		RouteInfo routeInfo = routeService.findByStationInfo(ticket.getStartstation(), ticket.getEndstation(),train.getId());
		Date date = new Date();
		//2.车票数据封装
		ticket.setTrain(train);
		ticket.setTdate(date);
		ticket.setGnumber(ticket.getGnumber());  //车厢
		ticket.setSeatnumber(ticket.getSeatnumber());  //座位号
		ticket.setStartstation(ticket.getStartstation());
		ticket.setEndstation(ticket.getEndstation());
		ticket.setUname(uuser.getName());  //用户
		ticket.setUtype(1);   //用户状态
		ticket.setUidnumber(uuser.getIdnumber());  //用户身份证
		ticket.setSaletype(1);        //售票方式
		ticket.setSaletime(date);     //购买时间
		ticket.setStatus(1);            //车票状态
		ticket.setRevisetime(1);       //状态次数
		
		//3.生成席位
		Seat seat = new Seat();
		seat.setTrain(train);
		seat.setSdate(date);
		seat.setGnumber(ticket.getGnumber());   //车厢号
		seat.setSeatnumber(ticket.getSeatnumber());   //座位号
		seat.setStartstation(ticket.getStartstation());  //起始站
		seat.setEndstation(ticket.getEndstation());     //结束站
		seat.setStatus(1);         //席位状态
		//存储席位
		//生产订单
		Orders orders2 = new Orders();
		orders2.setUuser(uuser);        //订单用户
		orders2.setTicket(ticket);  //订单车票
		orders2.setStatus(1);    //订单状态
		orders2.setMaketime(date);  //订单时间
		 msg = ordersService.save(orders2,ticket,seat);
		 if("success".equals(msg)){
			 //订单生成成功之后移除这张车票
			List<Integer> listT = routeInfo.getListT();   //获得可买的票 
			listT.remove(ticket.getSeatnumber());  //订单生成之后移除可购买车票
		 }
		 return msg;
	}
	
	//查询订单
	public String findByInfo(){
		String msg = "error";
		Uuser uuser = (Uuser) sessionMap.get("uuser");
		if(uuser == null){
			return msg;
		}
		OrdersVo ordersvo = ordersVoService.findByInfo(id);
		if(ordersvo != null ){
			requstMap.put("ordersvoFormService", ordersvo);
			msg = "success";
		}
		return msg;
	}
	
	public String findAll(){
		String msg = "error";
		Uuser uuser = (Uuser) sessionMap.get("uuser");
		if(uuser == null){
			return msg;
		}
		
		List<Orders> ordersList = ordersService.findByProperty("uuser.idnumber ", uuser.getIdnumber());
		if(ordersList != null && ordersList.size() > 0){
			requstMap.put("ordersListFormService", ordersList);
			msg = "success";
		}
		return msg;
	}
	
	
	public String delete(){
		String msg = "error";
		Uuser uuser = (Uuser) sessionMap.get("uuser");
		if(uuser == null){
			return msg;
		}
		Orders orders = new Orders();
		orders.setId(id);
		return ordersService.delete(orders);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
