<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增管理员</title>
</head>
<body>
	<h3>增加管理员</h3>
	<form action="${pageContext.request.contextPath}/admin_save.action" method="post">
		<table border="1">
			<tr>
				<td>管理员编号</td>
				<td><input type="text" name="id" value="100" /></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value="好汉"  /></td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td><input type="password" name="password" value="root" /></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" name="name" value="真实姓名"  /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
				<select name="sex">
						<option value="0" 
						${adminListFromService.type=='0'?"selected='selected'":""}>男</option>
						<option value="1" 
						${adminListFromService.type=='1'?"selected='selected'":""}>女</option>
				</select></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="idnumber" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="tel" value="123"  /></td>
			</tr>
			<tr>
				<td>人员人事</td>
					<td><select name="type">
						<option value="0" 
						${adminListFromService.type=='0'?"selected='selected'":""}>人事</option>
						<option value="1" 
						${adminListFromService.type=='1'?"selected='selected'":""}>基础</option>
						<option value="2"   
						${adminListFromService.type=='2'?"selected='selected'":""}>计划</option>
						<option value="3" 
						${adminListFromService.type=='3'?"selected='selected'":""}>调度</option>
						<option value="4" 
						${adminListFromService.type=='4'?"selected='selected'":""}>票务</option>
						<option value="5"   
						${adminListFromService.type=='5'?"selected='selected'":""}>财务</option>
					</select>
				</td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="点击提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="点击重置"/>
	</form>
</body>
</html>