<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工详情信息</title>
</head>
<body>
	<h3>员工信息修改</h3>
	<form action="${pageContext.request.contextPath}/carriage_update.action"
		method="post">
		<table border="1">
			<tr>
				<td>列车编组编号</td>
				<td>车次代码</td>
				<td>车厢号	</td>
				<td>车厢座席数量	</td>
				<td>车厢类型</td>
				<td>操作</td>
			</tr>
			<tr>
		<!-- 	id	tid	cnumber	seatnumber	type -->
			
				<td>
					${carriage.id} <input type="hidden" value="${carriage.id}" name="id" />
				</td>
				<td><select name="tid">
						<c:forEach var="s" items="${trainlist}">
							<option value="${s.id}"
								${carriage.train.id==${s.id}?"selected='selected'":""}>${s.id}</option>
						</c:forEach>
				</select></td>
				<td><input type="text" value="${carriage.cnumber}" name="cnumber" /></td>
				<td><input type="text" value="${carriage.seatnumber}"
					name="seatnumber" /></td>
				<td><input type="text" value="${carriage.type}"
					name="type" /></td>
				<td><input type="submit" value="点击修改"
					onclick="return confirm('确定要修改吗')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>