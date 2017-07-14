package com.java.service.impl;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.ICarriageDao;
import com.java.dao.idao.IRouteDao;
import com.java.dao.idao.ISeatDao;
import com.java.dao.pojo.RouteInfo;
import com.java.service.iservice.IRouteService;
import com.java.util.ComputeSerialUtil;

import hibernate.Carriage;
import hibernate.Route;
import hibernate.Seat;

@Service("routeService")
public class ServiceRouteImpl implements IRouteService {
	@Autowired
	@Qualifier("routeDao")
	private IRouteDao routeDao;
	
	@Autowired
	@Qualifier("carriageDao")
	private ICarriageDao carriageDao;
	
	@Autowired
	@Qualifier("seatDao")
	private ISeatDao seatDao;

	@Transactional
	@Override
	public String save(Route t) {
		String msg = "error";
		try {
			List<Route> routes = routeDao.findByProperty("id", t.getId());
			if (routes.size() == 0) {
				routeDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Route t) {
		String msg = "error";
		try {
			Route e = routeDao.findById(t.getId());
			if (e != null) {
				routeDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Route newT) {
		String msg = "error";
		try {
			Route e = routeDao.findById(newT.getId());
			if (e != null) {
				routeDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Route> findAll() {
		List<Route> routes = null;
		try {
			routes = routeDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routes;
	}

	@Transactional(readOnly = true)
	@Override
	public Route findById(Integer k) {
		Route route = null;
		try {
			route = routeDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return route;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Route> findByProperty(String propName, Object propVal) {
		List<Route> routes = null;
		try {
			routes = routeDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routes;
	}
	
	//获得车次 以及可买的票
	@Transactional(readOnly = true)
	@Override
	public List<RouteInfo> findByStationInfo(String fromStation, String toStation) {
		List<RouteInfo> routeInfos = new ArrayList<>();
		try {
			List<Object[]> objects = routeDao.findByStationInfo(fromStation,toStation);
			//数据封装
			getRouteInfo(fromStation, toStation, routeInfos, objects);  //数据封装
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routeInfos;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public RouteInfo findByStationInfo(String fromStation, String toStation,String tid){
		List<RouteInfo> routeInfos = new ArrayList<>();
		try {
			List<Object[]> objects = routeDao.findByIdStationInfo(fromStation, toStation, tid);
			getRouteInfo(fromStation, toStation, routeInfos, objects); //数据封装
		} catch (Exception e) {
			e.printStackTrace();
		}  
		if(routeInfos != null && routeInfos.size() >0){
			return routeInfos.get(0);
		}
		return null;
	}
	
	//数据封装
	private void getRouteInfo(String fromStation, String toStation, List<RouteInfo> routeInfos, List<Object[]> objects)
			throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		NumberFormat nf = new  DecimalFormat( "0.0 "); 
		for (Object[] objects2 : objects) {
			RouteInfo routeInfo = new RouteInfo();
			//private String tid;  //列车次
			String tid = objects2[0].toString();
			List<Carriage> carriages = carriageDao.findByProperty("train.id", tid);
			routeInfo.setCarriages(carriages);
			routeInfo.setTid(tid);  //车次
			//private String fromStation;  //始发站  objects2[1].toString();
			routeInfo.setFromStation(fromStation);
			//private String toStation; //终点站  objects2[2].toString()
			routeInfo.setToStation(toStation);
			//private Date startime; //发车时间
			String starttime = objects2[3].toString();
			routeInfo.setStartime(starttime);
			//private Date endtime;  //到达时间
			String endtime = objects2[4].toString();
			routeInfo.setEndtime(endtime);
			//private String fromsiteorder; //出发地的车站序列号
			String ft = objects2[5].toString();
			routeInfo.setFromsiteorder(ft);
			//private String tositeorder; //达到站的车站序列号
			String tt = objects2[6].toString();
			routeInfo.setTositeorder(tt);
			//private String frommile;  //出发地到始发站的里程数
			routeInfo.setFrommile(objects2[7].toString());
			//private String tomile; //终点站到始发站的里程数
			routeInfo.setTomile(objects2[8].toString());
			//private Double price;  //区间价格
			int price = (Integer.parseInt(objects2[8].toString())-Integer.parseInt(objects2[7].toString()));
			routeInfo.setPrice((double)price+0.5);
			//相差时间
			Date a = sdf.parse(starttime);
			Date b = sdf.parse(endtime);
			long c = (b.getTime() - a.getTime());
			//计算经历的时间
			Double dlasta = c/1000/(3600*1.0);
			Double dlastb = Double.parseDouble(nf.format(dlasta));
			String last = "";
			String atime = dlastb+"";
			String[] atimes = atime.split("[.]");
			int itimea = Integer.parseInt(atimes[0]);
			int itimeb = Integer.parseInt(atimes[1])*6;
			if(itimea != 0){
				last = last + itimea+"小时";
			}
			if(itimeb != 0){
				last = last + itimeb+"分钟";
			}
			routeInfo.setLast(last);
			List<Seat> seats = seatDao.findByProperty("train.id", tid); //此段已售出信息
			//计算与余票surplusTicket
			int surplusTicket = 100;  //获取车厢所有的车票  将所有的座位号加入到list集合中  默认是100张
			List<Integer> listT = new ArrayList<>();
			for(int i = 1;i <= surplusTicket; i++){
				listT.add(i);         //将车厢所有座位计算入内
			}
			
			int seatnumber = 100; //座位号
			List<String> listS = new ArrayList<>();  //计算出用户可购买的已经被其他区间所有购买的车票
			int yft  = Integer.parseInt(ft);   //用户选择的起点站序号
			int ytt = Integer.parseInt(tt);   //用户选择终点站序号
			if(seats != null && seats.size() > 0 ){
				for (Seat seat : seats) {
					int gft = ComputeSerialUtil.getSerial(seat.getStartstation());   //已买起点站序号
					int gtt = ComputeSerialUtil.getSerial(seat.getEndstation());     //已买终点站序号
					Integer snum = seat.getSeatnumber();   //卖出票的座位号
					int status = seat.getStatus(); //计算   //用户做退票的功能
					String sgg = snum+","+gft+","+gtt;   //讲车票区间连接 (唯一标识符)
					listS.add(sgg);
					if((gft == yft || gtt == ytt) && status == 1){   //起始站相同 这张票不能购买
						surplusTicket-=1;
						 //如果这张车票已经被购买 那么就移除
						listS.remove(sgg);
						listT.remove(snum);
					}else if(gft < ytt && gtt >= ytt && status == 1){  //如果两张票有交叉就不能购买
						surplusTicket-=1;
						listS.remove(sgg);
						listT.remove(snum);
					}else if(gft < yft && gtt > yft && status == 1){    //如果两张票有交叉就不能购买
						surplusTicket-=1;
						listS.remove(sgg);
						listT.remove(snum);
					}
				}
			}
			
			//最优购票
			if(listS != null && listS.size() > 0){
				Map<String, Integer> mapT = new HashMap<>();   //存入的是车票   以及车票卖出的区间
				int distance = 0;   //统计站之间相隔的站数
				for (String string : listS) {
					String[] strings = string.split("[,]"); 	 //获得此座位卖出的区间  
					String seat = strings[0];        //获得座位
					int startEndS = Integer.parseInt(strings[2]) - Integer.parseInt(strings[1]);  //计算出区间
					int num = 0;
					if(mapT.containsKey(seat)){       //如果这张票已经存在 那么就将站之间的相隔的站数直接加上
						num = mapT.get(seat) + startEndS;  
						mapT.put(seat, num);  //重新赋值进去
					}else{
						num = startEndS;
						mapT.put(seat, startEndS);
					} 
					int setnumbera = Integer.parseInt(seat);  //获得座位
					if(num > distance && listT.contains(setnumbera)){   //始终优先选择卖出最多区间的车票给用户  并且在list(可买车票)集合中
						distance = num;        
						seatnumber = Integer.parseInt(seat);
					}
				}
			}
			if(seatnumber == 100){
				seatnumber = listT.get(0);
			}
			routeInfo.setSurplusTicket(surplusTicket);
			routeInfo.setSeatnumber(seatnumber);
			routeInfos.add(routeInfo);
		}
	}
}
