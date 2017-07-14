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
			<td>旅程区编号</td>
			<td>里程区段From</td>
			<td>里程区段To</td>
			<td>区段数	</td>
			<td>每区段里程</td>
		</tr>
<!-- 旅程区编号	里程区段From	里程区段To	区段数	每区段里程
id	journeyfrom	journeyto	jnumber	permile

 -->		
		<c:forEach var="journey" items="${journeyListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${journey.id}</td>
			<td>${journey.journeyfrom}</td>
			<td>${journey.journeyto}</td>
			<td>${journey.jnumber}</td>
			<td>${journey.permile}</td>
		</c:forEach>
	</table>
</body>
</html>