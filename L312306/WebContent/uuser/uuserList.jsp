<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息表</title>
</head>
<body>
	<h3>用户信息表</h3>
	<table border="1" >
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
		<c:forEach var="uuser" items="${uuserListFromService}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${uuser.username}</td>
			<td>${uuser.name}</td>
			<td>${uuser.sex!=0?"女":'男'}</td>
			<td>${uuser.idnumber}</td>
			<td>${uuser.tel}</td>
			<td>${uuser.type}</td>
			<td>
				<a href='${pageContext.request.contextPath}/uuser_delete.action?id=${uuser.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/uuser_find_ById.action?id=${uuser.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='${pageContext.request.contextPath}/uuser/uuserSave.jsp'>增加用户</a>
	<form
		action="${pageContext.request.contextPath }/uuser_find_findByProperty.action"
		method="post">
		查询条件：
		<select name="propName">
			<option value="username" selected="selected">用户名查询</option>
			<option value="name" selected="selected">真名查询</option>
			<option value="idnumber" selected="selected">身份证查询</option>
			<option value="id" selected="selected">id查询</option>
		</select>
		<input type="text" name="propVal" value="t32"> 
		<br/>
		<input type="submit" value="查询" />
	</form>
</body>
</html>