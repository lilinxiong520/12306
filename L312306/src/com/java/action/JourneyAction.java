package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.IJourneyService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Journey;

@Controller("journeyAction")
@Scope("prototype")
public class JourneyAction implements ModelDriven<Journey>, RequestAware {
	@Autowired
	@Qualifier("journeyService")
	private IJourneyService journeyService;

	private Journey journey = new Journey();
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
	public Journey getModel() {
		return journey;
	}

	public String save() {
		return journeyService.save(journey);
	}

	public String delete() {
		return journeyService.delete(journey);
	}

	public String update() {
		return journeyService.update(journey);
	}

	public String findAll() {
		String msg = "error";
		List<Journey> journeyList = journeyService.findAll();
		if (journeyList != null && journeyList.size() > 0) {
			requestMap.put("journeyListFromServer", journeyList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Journey e = journeyService.findById(journey.getId());
		if (e != null) {
			List<Journey> journeyList = new ArrayList<Journey>();
			journeyList.add(e);
			requestMap.put("journeyListFromServer", journeyList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("journeyno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Journey> journeyList = journeyService.findByProperty(propName,val);//val是类型转换后的值
		if (journeyList != null && journeyList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("journey", journeyList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("journeyListFromServer", journeyList);
				msg = "success";
			}
		}
		return msg;
	}

}
