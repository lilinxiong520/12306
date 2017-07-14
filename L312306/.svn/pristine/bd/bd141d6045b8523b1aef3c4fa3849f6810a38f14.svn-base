<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>线路详情信息</title>
</head>
<body>
	<h3>线路信息修改</h3>
	<form action="${pageContext.request.contextPath}/rount_update.action"
		method="post">
		<table border="1">
			<tr>
				<td>线路编号</td>
				<td>车次代码</td>
				<td>站序</td>
				<td>车站名</td>
				<td>里程</td>
				<td>发车时间</td>
				<td>到站时间</td>
				<td>停留时间</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>
					${rount.id} <input type="hidden" value="${rount.id}" name="id" />
				</td>
				<td><select name="${rount.train}">
						<c:forEach var="s" items="${trainlist}">
							<option value="${s.id}"
								${rount.train.id==${s.id}?"selected='selected'":""}>${s.name}</option>
						</c:forEach>
				</select>
				</td>
				
				<td><input type="text" value="${rount.siteorder}" name="siteorder" /></td>
				<td><input type="text" value="${rount.site}" name="site" /></td>
				<td><input type="text" value="${rount.mile}"
					name="mile" /></td>
				<td><input type="datetime" value="${rount.starttime}"
					name="starttime" /></td>
				<td><input type="datetime" value="${rount.endtime}"
					name="endtime" /></td>
				<td><input type="text" value="${rount.staytim}" name="staytim" /></td>
				<td><input type="submit" value="点击修改"
					onclick="return confirm('确定要修改吗')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>