package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.ITicketService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Ticket;

@Controller("ticketAction")
@Scope("prototype")
public class TicketAction implements ModelDriven<Ticket>, RequestAware {
	@Autowired
	@Qualifier("ticketService")
	private ITicketService ticketService;
	private Ticket ticket = new Ticket();
	private Map<String, Object> requestMap;
	private String type;// 访问类型:是查询还是更新
	private String propName;// 查询条件:属性名
	private String propVal;// 属性值

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
	public Ticket getModel() {
		return ticket;
	}
	
	//生成车票
	public String save() {
		return ticketService.save(ticket);
	}

	public String delete() {
		return ticketService.delete(ticket);
	}

	public String update() {
		return ticketService.update(ticket);
	}

	public String findAll() {
		String msg = "error";
		List<Ticket> ticketList = ticketService.findAll();
		if (ticketList != null && ticketList.size() > 0) {
			requestMap.put("ticketListFromServer", ticketList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Ticket e = ticketService.findById(ticket.getId());
		if (e != null) {
			List<Ticket> ticketList = new ArrayList<Ticket>();
			ticketList.add(e);
			requestMap.put("ticketListFromServer", ticketList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("ticketno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Ticket> ticketList = ticketService.findByProperty(propName,val);//val是类型转换后的值
		if (ticketList != null && ticketList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("ticket", ticketList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("ticketListFromServer", ticketList);
				msg = "success";
			}
		}
		return msg;
	}

}
