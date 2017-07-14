package com.java.dao.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hibernate.Carriage;

public class RouteInfo implements Serializable{

	private String tid;  //列车次
	private String fromStation;  //始发站
	private String toStation; //终点站
	private String startime; //发车时间
	private String endtime;  //到达时间
	private String fromsiteorder; //出发地的车站序列号
	private String tositeorder; //达到站的车站序列号
	private String frommile;  //出发地到始发站的里程数
	private String tomile; //终点站到始发站的里程数
	private Double price;  //区间价格
	private String last;   //  历时
	private int surplusTicket;  //剩余多少票
	private List<Integer> listT = new ArrayList<>() ;   //当次可以购买的座位号
	private Map<String, Integer> map = new HashMap<>();   
	//private List<Map<String, Integer>> list = new ArrayList<>();  //火车所有座位信息  String 区间 1 - 4   Integer 已经存在的车票 1-10
	private int seatnumber;   //座位号
	private int gnumber; //车厢
	
	private List<Carriage> carriages;   //zuoweixinxi 
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getFromsiteorder() {
		return fromsiteorder;
	}
	public void setFromsiteorder(String fromsiteorder) {
		this.fromsiteorder = fromsiteorder;
	}
	public String getTositeorder() {
		return tositeorder;
	}
	public void setTositeorder(String tositeorder) {
		this.tositeorder = tositeorder;
	}
	public String getFrommile() {
		return frommile;
	}
	public void setFrommile(String frommile) {
		this.frommile = frommile;
	}
	public String getTomile() {
		return tomile;
	}
	public void setTomile(String tomile) {
		this.tomile = tomile;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public List<Integer> getListT() {
		return listT;
	}
	public void setListT(List<Integer> listT) {
		this.listT = listT;
	}
	public int getSurplusTicket() {
		return surplusTicket;
	}
	public void setSurplusTicket(int surplusTicket) {
		this.surplusTicket = surplusTicket;
	}
	public List<Carriage> getCarriages() {
		return carriages;
	}
	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
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
	@Override
	public String toString() {
		return "RouteInfo [tid=" + tid + ", fromStation=" + fromStation + ", toStation=" + toStation + ", startime="
				+ startime + ", endtime=" + endtime + ", fromsiteorder=" + fromsiteorder + ", tositeorder="
				+ tositeorder + ", frommile=" + frommile + ", tomile=" + tomile + ", price=" + price + ", last=" + last
				+ ", surplusTicket=" + surplusTicket + ", listT=" + listT + ", map=" + map + ", seatnumber="
				+ seatnumber + ", gnumber=" + gnumber + ", carriages=" + carriages + "]";
	}
	public RouteInfo(String tid, String fromStation, String toStation, String startime, String endtime,
			String fromsiteorder, String tositeorder, String frommile, String tomile, Double price) {
		super();
		this.tid = tid;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.startime = startime;
		this.endtime = endtime;
		this.fromsiteorder = fromsiteorder;
		this.tositeorder = tositeorder;
		this.frommile = frommile;
		this.tomile = tomile;
		this.price = price;
	}
	public RouteInfo() {
		super();
	}
	
}	
