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

import com.java.service.iservice.IPlanService;
import com.java.service.iservice.ITrainService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Plan;
import hibernate.Train;

@Controller("planAction")
@Scope("prototype")
public class PlanAction2 implements ModelDriven<Plan>, RequestAware ,SessionAware{
	@Autowired
	@Qualifier("planService")
	private IPlanService planService;
	@Autowired
	@Qualifier("trainService")
	private ITrainService trainService;
	private Plan plan = new Plan();
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
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
	public Plan getModel() {
		return plan;
	}

	public String save() {
		return planService.save(plan);
	}

	public String delete() {
		return planService.delete(plan);
	}

	public String update() {
		return planService.update(plan);
	}

	public String findAll() {
		String msg = "error";
		List<Plan> planList = planService.findAll();
		if (planList != null && planList.size() > 0) {
			requestMap.put("planListFromServer", planList);
			msg = "success";
			List<Train> trainlist = trainService.findAll();
			if(trainlist != null && trainlist.size() > 0){
				sessionMap.put("trainlist", trainlist);
			}
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Plan e = planService.findById(plan.getId());
		if (e != null) {
			List<Plan> planList = new ArrayList<Plan>();
			planList.add(e);
			requestMap.put("planListFromServer", planList);
			msg = "success";
			if("update".equals(type1)){
				requestMap.put("plan", e);
				msg="updatesuccess";
			}
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("planno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Plan> planList = planService.findByProperty(propName,val);//val是类型转换后的值
		if (planList != null && planList.size() > 0) {
			if ("update".equals(type1)) {
				requestMap.put("plan", planList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("planListFromServer", planList);
				msg = "success";
			}
		}
		return msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap =arg0;
		
	}

}
