package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.IJourneyrateService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Journeyrate;

@Controller("journeyrateAction")
@Scope("prototype")
public class JourneyrateAction implements ModelDriven<Journeyrate>, RequestAware {
	@Autowired
	@Qualifier("journeyrateService")
	private IJourneyrateService journeyrateService;

	private Journeyrate journeyrate = new Journeyrate();
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
	public Journeyrate getModel() {
		return journeyrate;
	}

	public String save() {
		return journeyrateService.save(journeyrate);
	}

	public String delete() {
		return journeyrateService.delete(journeyrate);
	}

	public String update() {
		return journeyrateService.update(journeyrate);
	}

	public String findAll() {
		String msg = "error";
		List<Journeyrate> journeyrateList = journeyrateService.findAll();
		if (journeyrateList != null && journeyrateList.size() > 0) {
			requestMap.put("journeyrateListFromServer", journeyrateList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Journeyrate e = journeyrateService.findById(journeyrate.getId());
		if (e != null) {
			List<Journeyrate> journeyrateList = new ArrayList<Journeyrate>();
			journeyrateList.add(e);
			requestMap.put("journeyrateListFromServer", journeyrateList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("journeyrateno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Journeyrate> journeyrateList = journeyrateService.findByProperty(propName,val);//val是类型转换后的值
		if (journeyrateList != null && journeyrateList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("journeyrate", journeyrateList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("journeyrateListFromServer", journeyrateList);
				msg = "success";
			}
		}
		return msg;
	}

}
