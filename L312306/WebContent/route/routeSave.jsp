<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增线路</title>
</head>
<body>
	<h3>增加线路</h3>
	<form action="${pageContext.request.contextPath}/rount_save.action"
		method="post">
		<table border="1">
			<tr>
				<td>线路编号</td>
				<td><input type="text" name="id" value="" /></td>
			</tr>
			<tr>
				<td>车次代码</td>
				<td><select name="train.id">
						<c:forEach var="s" items="${trainlist}">
							<option value="${s.id}">${s.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>站序</td>
				<td><input type="text" name="siteorder" /></td>
			</tr>
			<tr>
				<td>车站名</td>
				<td><input type="text" name="site" /></td>
			</tr>
			<tr>
				<td>里程</td>
				<td><input type="text" name="mile" /></td>
			</tr>
			<tr>
				<td>发车时间</td>
				<td><input type="date" name="starttim" /></td>
			</tr>
			<tr>
				<td>到站时间</td>
				<td><input type="date" name="endtime" /></td>
			</tr>
			<tr>
				<td>停留时间</td>
				<td><input type="text" name="taytime" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="点击提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="点击重置" />
	</form>
</body>
</html>