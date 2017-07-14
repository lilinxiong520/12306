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
	<form action="${pageContext.request.contextPath}/uuser_update.action"
		method="post">
		<table border="1">
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>真是姓名</td>
				<td>性别</td>
				<td>身份证号码</td>
				<td>联系电话</td>
				<td>类型</td>
				<td>操作</td>
			</tr>
			<tr>
				<!-- 	id	tid	cnumber	seatnumber	type -->

				<td>${uuser.id} <input type="hidden" value="${uuser.id}"
					name="id" />
				</td>
				<td>${uuser.username} <input type="hidden" value="${uuser.username}"
					name="username" />
				</td>
				<td>${uuser.name} <input type="hidden" value="${uuser.name}"
					name="name" />
				</td>
				<td>${uuser.sex==0?"女":"男"}<input type="hidden" value="${uuser.sex}"
					name="sex" /></td>
				<td><input type="text" value="${uuser.idnumber}" name="idnumber" /></td>
				<td><input type="text" value="${uuser.tel}" name="tel" /></td>
				<td><select name="type">
						<option value="0"
							${uuser.type=='0'?"selected='selected'":""}>已激活</option>
						<option value="1"
							${uuser.type=='1'?"selected='selected'":""}>未激活</option>
				</select></td>
				<td><input type="submit" value="点击修改"
					onclick="return confirm('确定要修改吗')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>