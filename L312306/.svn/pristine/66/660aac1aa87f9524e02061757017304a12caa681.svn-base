<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计划管理</title>
</head>
<body>
<!-- 计划代码	车次代码	车厢号	比较	车站
	id	tid	gnumber	compare	sid -->

	<h3>计划信息</h3>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>递远递减率编号</td>
			<td>里程区段From</td>
			<td>里程区段To</td>
			<td>递减率	票价率	</td>
			<td>各区段全程票价	</td>
			<td>区段累计票价	</td>
		</tr>
<!-- 递远递减率编号	里程区段From	里程区段To	递减率	票价率	各区段全程票价	区段累计票价
		id	journeyfrom	journeyto	reducerate	pricerate	thisprice	sumprice
 -->		
		<c:forEach var="journeyrate" items="${journeyrateListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${journeyrate.id}</td>
			<td>${journeyrate.journeyfrom}</td>
			<td>${journeyrate.journeyto}</td>
			<td>${journeyrate.reducerate}</td>
			<td>${journeyrate.pricerate}</td>
			<td>${journeyrate.thisprice}</td>
			<td>${journeyrate.sumprice}</td>
		</c:forEach>
	</table>
</body>
</html>