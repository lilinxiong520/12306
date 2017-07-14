package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.ISeatService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Seat;

@Controller("seatAction")
@Scope("prototype")
public class SeatAction implements ModelDriven<Seat>, RequestAware {
	@Autowired
	@Qualifier("seatService")
	private ISeatService seatService;

	private Seat seat = new Seat();
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
	public Seat getModel() {
		return seat;
	}

	public String save() {
		return seatService.save(seat);
	}

	public String delete() {
		return seatService.delete(seat);
	}

	public String update() {
		return seatService.update(seat);
	}

	public String findAll() {
		String msg = "error";
		List<Seat> seatList = seatService.findAll();
		if (seatList != null && seatList.size() > 0) {
			requestMap.put("seatListFromServer", seatList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Seat e = seatService.findById(seat.getId());
		if (e != null) {
			List<Seat> seatList = new ArrayList<Seat>();
			seatList.add(e);
			requestMap.put("seatListFromServer", seatList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("seatno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Seat> seatList = seatService.findByProperty(propName,val);//val是类型转换后的值
		if (seatList != null && seatList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("seat", seatList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("seatListFromServer", seatList);
				msg = "success";
			}
		}
		return msg;
	}

}
