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
			<td>计划代码</td>
			<td>车次代码</td>
			<td>车厢号	比较</td>
			<td>车站	</td>
			<td>操作</td>
		</tr>
		<c:forEach var="plan" items="${planListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${plan.id}</td>
			<td>${plan.train.id}</td>
			<td>${plan.gnumber}</td>
			<td>${plan.compare}</td>
			<td>${plan.station.id}</td>
			<td>
				<a href='${pageContext.request.contextPath}/plan_delete.action?id=${plan.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/plan_find_ById.action?id=${plan.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='${pageContext.request.contextPath}/plan/planSave.jsp'>增加线路</a>
	<form
		action="${pageContext.request.contextPath }/plan_find_findByProperty.action"
		method="post">
		查询条件：
		<select name="propName">
			<option value="id" selected="selected">计划编号</option>
			<option value="tid" selected="selected">根据车次</option>
			<option value="sid" selected="selected">根据</option>
		</select>
		<input type="text" name="propVal" value="t32"> 
		<br/>
		<input type="submit" value="查询" />
	</form>
</body>
</html>