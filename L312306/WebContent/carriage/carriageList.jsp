<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>列车编组管理</title>
</head>
<body>
	<h3>列车编组</h3>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>列车编组编号</td>
			<td>车次代码</td>
			<td>车厢号	</td>
			<td>车厢座席数量	</td>
			<td>车厢类型</td>
			<td>操作</td>
		</tr>
		<c:forEach var="carriage" items="${carriageListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${carriage.id}</td>
			<td>${carriage.train.id}</td>
			<td>${carriage.cnumber}</td>
			<td>${carriage.seatnumber}</td>
			<td>${carriage.type}</td>
			<td>
				<a href='${pageContext.request.contextPath}/carriage_delete.action?id=${carriage.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/carriage_find_ById.action?id=${carriage.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='${pageContext.request.contextPath}/carriage/carriageSave.jsp'>增加线路</a>
	<form
		action="${pageContext.request.contextPath }/carriage_find_findByProperty.action"
		method="post">
		查询条件：
		<select name="propName">
			<option value="id" selected="selected">列车编号查询</option>
			<option value="cnumber" selected="selected">车厢号查询</option>
		</select>
		<input type="text" name="propVal" value="t32"> 
		<br/>
		<input type="submit" value="查询" />
	</form>
</body>
</html>