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
	<form action="${pageContext.request.contextPath}/admin_update.action"
		method="post">
		<table border="1">
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>真实名字</td>
				<td>性别</td>
				<td>身份证号码</td>
				<td>联系电话</td>
				<td>类型</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>${adminFromService.id}<input type="hidden"
					value="${adminFromService.id}" name="id" /></td>
				<td><input type="text" value="${adminFromService.username}"
					name="username" /></td>
				<td><input type="text" value="${adminFromService.name}"
					name="name" /></td>
				<td><select name="sex">
						<option value="0"
							${adminFromService.sex=='0'?"selected='selected'":""}>男</option>
						<option value="1"
							${adminFromService.sex=='1'?"selected='selected'":""}>女</option>
				</select></td>
				<td><input type="text" value="${adminFromService.idnumber}"
					name="idnumber" /></td>
				<td><input type="text" value="${adminFromService.tel}"
					name="tel" /></td>
				<td><input type="text" value="${adminFromService.type}"
					name="type" /></td>
				<td><input type="submit" value="点击修改"
					onclick="return confirm('确定要修改吗')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>