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

import com.java.service.iservice.IStationService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Station;
import hibernate.Uuser;

@Controller("stationAction")
@Scope("prototype")
public class StationAction implements ModelDriven<Station>, RequestAware ,SessionAware{
	@Autowired
	@Qualifier("stationService")
	private IStationService stationService;

	private Station station = new Station();
	private Map<String, Object> requestMap;
	private String type;// 访问类型:是查询还是更新
	private String propName;// 查询条件:属性名
	private String propVal;// 属性值
	Map<String, Object> sessionMap;

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
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public Station getModel() {
		return station;
	}

	public String save() {
		return stationService.save(station);
	}

	public String delete() {
		return stationService.delete(station);
	}

	public String update() {
		return stationService.update(station);
	}

	public String findAll() {
		String msg = "error";
		List<Station> stationList = stationService.findAll();
		
		if (stationList != null && stationList.size() > 0) {
			requestMap.put("stationListFromServer", stationList);
			msg = "success";
		}
		return msg;
	}
	public String findById(){
		String msg = "error";
		Station e = stationService.findById(station.getId());
		if(e != null){
			if("update".equals(type)){
				requestMap.put("c", e);
				msg = "updatesuccess";
			}else{
				List<Station> stationList = new ArrayList<Station>();
				stationList.add(e);
				requestMap.put("stationListFromServer", stationList);
				msg = "success";
			}
		}
		return msg;
	}
	

	

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		List<Station> stationList = stationService.findByProperty(propName,val);//val是类型转换后的值
		if (stationList != null && stationList.size() > 0) {
				requestMap.put("stationListFromServer", stationList);
				msg = "success";
			
		}
		return msg;
	}
	
	
	

}
