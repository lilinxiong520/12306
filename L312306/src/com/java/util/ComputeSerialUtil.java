package com.java.util;

public class ComputeSerialUtil {
	public  static Integer getSerial(String statioin){
		int num = 0;
		if(statioin != null){
			if("广州".equals(statioin)){
				num = 1;
			}else if("长沙".equals(statioin)){
				num = 2;
			}else if("武昌".equals(statioin)){
				num = 3;
			}else if("北京西".equals(statioin)){
				num = 4;
			}else if("济南".equals(statioin)){
				num = 5;
			}else if("潍坊".equals(statioin)){
				num = 6;
			}else if ("青岛".equals(statioin)){
				num = 7;
			}else if("威海".equals(statioin)){
				num = 8;
			}
		}
		System.out.println(num+"==========ComputeSerialUtil");
		return num;
	}
}
