<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增用戶</title>
</head>
<body>
	<h3>新增用戶</h3>
	<form action="${pageContext.request.contextPath}/uuser_save.action"
		method="post">
		<table border="1">
			<tr>
				<td>新增用戶編號</td>
				<td><input type="text" name="id" value="" /></td>
			</tr>
			<tr>
				<td>用戶名</td>
				<td><input type="text" name="username" value="" /></td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="text" name="password" value="" /></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><select name="sex">
				<option value="0">女</option>
				<option value="1">男</option>
				</select></td>
			</tr>
			<tr>
				<td>身份证</td>
				<td><input type="text" name="idnumber" value="" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="tel" value="" /></td>
			</tr>
			<tr>
				<td>类型</td>
				<td><select name="type">
				<option value="0">未激活</option>
				<option value="1">已激活</option>
				</select></td>
			</tr>
			</table>
		<br /> <input type="submit" value="点击提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="点击重置" />
	</form>
</body>
</html>