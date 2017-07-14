<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin_login.action" method="post">
		<table>
			<tr>
			<td colspan="2">管理员登录窗口</td>
			</tr>
			<tr>
				<td><label for="username">用户名:</label></td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td><label for="password">用户密码:</label></td>
				<td><input type="password" name=password id="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"> </td>
			</tr>
		</table>

	</form>
</body>
</html>