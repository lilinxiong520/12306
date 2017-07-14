<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/uuser_register.action" method="post">
		<table>
			<tr>
			<td colspan="2">注册窗口</td>
			</tr>
			<tr>
				<td><label for="username">用户名:</label></td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td><label for="password">用户密码:</label></td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><label for="rpassword">重复密码:</label></td>
				<td><input type="password" name="rpassword" id="rpassword"></td>
			</tr>
			<tr>
				<td><label for="realname">真实姓名</label></td>
				<td><input type="text" name="name" id="realname"></td>
			</tr>
			<tr>
				<td><label for="sex">sex</label></td>
				<td>
					<select id="sex" name="sex">
						<option value="0" >女</option>
						<option value="1" >男</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="idnumber">身份证号码</label></td>
				<td><input type="text" name="idnumber" id="idnumber"></td>
			</tr>
			<tr>
				<td><label for="tel">联系电话</label></td>
				<td><input type="text" name="tel" id="tel"></td>
			</tr>
			<tr>
				<td><label for="type">类型</label></td>
				<td><select id="type" name="type">
						<option value="0" >普通用户</option>
						<option value="1" >会员用户</option>
					</select></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"> </td>
			</tr>
		</table>

	</form>
</body>
</html>