<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>线路管理表</title>
</head>
<body>
	<h3>线路信息表</h3>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>线路编号</td>
			<td>车次代码</td>
			<td>站序</td>
			<td>车站名	</td>
			<td>里程</td>
			<td>发车时间</td>
			<td>到站时间</td>
			<td>停留时间</td>
			<td>操作</td>
		</tr>
		<!-- 线路编号	车次代码	站序			车站名		里程		发车时间		到站时间	停留时间
			id		tid		siteorder	site	mile	starttime	endtime	staytim -->
		
		<c:forEach var="route" items="${routeListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${route.id}</td>
			<td>${route.train.id}</td>
			<td>${route.siteorder}</td>
			<td>${route.site}</td>
			<td>${route.mile}</td>
			<td>${route.starttim}</td>
			<td>${route.endtime}</td>
			<td>${route.taytime}</td>
			<td>
				<a href='${pageContext.request.contextPath}/route_delete.action?id=${route.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/route_find_ById.action?id=${route.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='route/routeSave.jsp'>增加线路</a>
	<form
		action="${pageContext.request.contextPath}/route_find_findByProperty.action"
		method="post">
		查询条件：
		<select name="propName">
			<option value="tid" selected="selected">列车编号查询</option>
			<option value="id" selected="selected">线路ID查询</option>
			<option value="site" selected="selected">站名查询</option>
		</select>
		<input type="text" name="propVal" value=""> 
		<br/>
		<input type="submit" value="查询" />
	</form>
</body>
</html>