<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员信息表</title>
</head>
<body>
	<h3>人员信息表</h3>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>管理员编号</td>
			<td>用户名</td>
			<td>真实姓名</td>
			<td>性别</td>
			<td>身份证号码</td>
			<td>联系电话</td>
			<td>类型</td>
			<td>操作</td>
		</tr>
		<c:forEach var="admin" items="${adminListFromService}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${admin.id}</td>
			<td>${admin.username}</td>
			<td>${admin.name}</td>
			<td>${admin.sex==0?"男":"女"}</td>
			<td>${admin.idnumber}</td>
			<td>${admin.tel}</td>
			<td>${admin.type}</td>
			<td>
				<a href='${pageContext.request.contextPath}/admin_delete.action?id=${admin.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/admin_find_ById.action?id=${admin.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='${pageContext.request.contextPath}/admin/adminSave.jsp'>增加管理员</a>
	
	<form action="${pageContext.request.contextPath}/admin_find_ByName.action" method="post">
		<input type="text" name="username" />
		<input  type="submit" value="按用户查找"/>
	</form>
	<form action="${pageContext.request.contextPath}/admin_find_ById.action" method="post">
		<input type="text" name="id" />
		<input  type="submit" value="按用户ID查找"/>
	</form>	
</body>
</html>