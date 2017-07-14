<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增列车</title>
</head>
<body>
	<h3>增加列车</h3>
	<form action="${pageContext.request.contextPath}/train_save.action"
		method="post">
		<table border="1">
			<tr>
				<td>列车号</td>
				<td><input type="text" name="id" value="" /></td>
			</tr>
			<tr>
				<td>起始站</td>
				<td><select name="stationByStartstation.id">
						<c:forEach var="s" items="${stationlist}">
							<option value="${s.id}">${s.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>终点站</td>
				<td><select name="stationByEndstation.id">
						<c:forEach var="m" items="${stationlist}">
							<option value="${m.id}"}>${m.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>起始时间</td>
				<td><input type="date" name="starttime" /></td>
			</tr>
			<tr>
				<td>终到时间</td>
				<td><input type="date" name="endtime" /></td>
			</tr>
			<tr>
				<td>总里程数</td>
				<td><input type="text" name="mile" /></td>
			</tr>
			<tr>
				<td>无座票数量</td>
				<td><input type="text" name="noseatnumber" /></td>
			</tr>
			<tr>
				<td>车辆车体分类</td>
				<td><input type="text" name="bodytype" /></td>
			</tr>
			<tr>
				<td>列车类型</td>
				<td><input type="text" name="type" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="点击提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="点击重置" />
	</form>
</body>
</html>