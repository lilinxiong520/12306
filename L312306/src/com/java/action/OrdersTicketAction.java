package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.IOrdersService;
import com.java.service.iservice.IOrdersTicketService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Orders;

@Controller("ordersTicketAction")
@Scope("prototype")
public class OrdersTicketAction implements ModelDriven<Orders>, RequestAware ,SessionAware{
	@Autowired
	@Qualifier("ordersService")
	private IOrdersService ordersService;	
	
	@Autowired
	@Qualifier("serviceOrdersTicket")
	IOrdersTicketService serviceOrdersTicket;

	private Orders orders = new Orders();
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	private String type;// 访问类型:是查询还是更新
	private String propName;// 查询条件:属性名
	private String propVal;// 属性值
	private String seat;  //席位
	private String tip;    //获得车票id
	private int tid;  //获得车票id
	
	private int seatnumber;   //座位号
	private int gnumber; //车厢
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public String getPropVal() {
		return propVal;
	}

	public void setPropVal(String propVal) {
		this.propVal = propVal;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public Orders getModel() {
		return orders;
	}
	
	public String delete() {
		return ordersService.delete(orders);
	}

	public String update() {
		return ordersService.update(orders);
	}
	
	//退票
	public String ticketOut(){
		serviceOrdersTicket.ticketOut(100, 100);
		return null;
	}
	
	public String findAll() {
		String msg = "error";
		List<Orders> ordersList = ordersService.findAll();
		if (ordersList != null && ordersList.size() > 0) {
			requestMap.put("ordersListFromServer", ordersList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Orders e = ordersService.findById(orders.getId());
		if (e != null) {
			List<Orders> ordersList = new ArrayList<Orders>();
			ordersList.add(e);
			requestMap.put("ordersListFromServer", ordersList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("ordersno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Orders> ordersList = ordersService.findByProperty(propName,val);//val是类型转换后的值
		if (ordersList != null && ordersList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("orders", ordersList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("ordersListFromServer", ordersList);
				msg = "success";
			}
		}
		return msg;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

	public int getGnumber() {
		return gnumber;
	}
	public void setGnumber(int gnumber) {
		this.gnumber = gnumber;
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
}
