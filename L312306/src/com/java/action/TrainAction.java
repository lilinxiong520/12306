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
import com.java.service.iservice.ITrainService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Station;
import hibernate.Train;

@Controller("trainAction")
@Scope("prototype1")
public class TrainAction implements ModelDriven<Train>,SessionAware, RequestAware {
	@Autowired
	@Qualifier("trainService")
	private ITrainService trainService;

	@Autowired
	@Qualifier("stationService")
	private IStationService stationService;
	private Train train = new Train();
	private Map<String, Object> requestMap;
	private Map<String, Object> seesionMap;
	private String type1;// 访问类型:是查询还是更新
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

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public Train getModel() {
		return train;
	}

	public String save() {
		return trainService.save(train);
	}

	public String delete() {
		return trainService.delete(train);
	}

	public String update() {
		return trainService.update(train);
	}

	public String findAll() {
		String msg = "error";
		List<Train> trainList = trainService.findAll();
		if (trainList != null && trainList.size() > 0) {
			requestMap.put("trainListFromServer", trainList);
			List<Station> stationList = stationService.findAll();
			if(stationList != null && stationList.size() > 0){
				seesionMap.put("stationlist", stationList);
			}
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Train e = trainService.findById(train.getId());
		if (e != null) {
			List<Train> trainList = new ArrayList<Train>();
			trainList.add(e);
			requestMap.put("trainListFromServer", trainList);
			msg = "success";
			if("updatesuccess".equals(type1)){
				msg="updatesuccess";
				requestMap.put("trainFromServer", e);
			}
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("trainno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Train> trainList = trainService.findByProperty(propName,val);//val是类型转换后的值
		if (trainList != null && trainList.size() > 0) {
			if ("update".equals(type1)) {
				requestMap.put("train", trainList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("trainListFromServer", trainList);
				msg = "success";
			}
		}
		return msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		seesionMap = arg0;
	}

}
