<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>列车编组</title>
</head>
<body>
	<h3>列车编组</h3>
	<form action="${pageContext.request.contextPath}/plan_save.action"
		method="post">
		<table border="1">
			<tr>
				<td>列车编组编号</td>
				<td><input type="text" name="id" value="" /></td>
			</tr>
			<tr>
				<td>车次代码</td>
				<td>
				<select name="tid">
						<c:forEach var="s" items="${trainlist}">
							<option value="${s.id}" }>${s.id}</option>
						</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<td>车厢号</td>
				<td><input type="text" name="cnumber" /></td>
			</tr>
			<tr>
				<td>车厢座席数量</td>
				<td><input type="text" name="seatnumber" /></td>
			</tr>
			<tr>
				<td>车厢类型</td>
				<td><input type="text" name="type" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="点击提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="点击重置" />
	</form>
</body>
</html>