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
	<form action="${pageContext.request.contextPath}/trainFromServer_update.action"
		method="post">
		<table border="1">
			<tr>
				<td>车次代码</td>
				<td>起始站</td>
				<td>终到站</td>
				<td>终到时间</td>
				<td>里程</td>
				<td>无座票数量</td>
				<td>车辆车体分类</td>
				<td>列车类型</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>
					${trainFromServer.id} <input type="hidden" value="${trainFromServer.id}" name="id" />
				</td>
				<td><select name="startstation">
						<c:forEach var="s" items="${stationlist}">
							<option value="${s.id}"
								${trainFromServer.startstation==${s.id}?"selected='selected'":""}>${s.name}</option>
						</c:forEach>
				</select></td>
				<td><select name="endstation">
						<c:forEach var="m" items="${stationlist}">
							<option value="${m.id}"
								${trainFromServer.startstation==${m.id}?"selected='selected'":""}>${m.name}</option>
						</c:forEach>
				</select></td>
				<td>${trainFromServer.starttime}"</td>
				<td>${trainFromServer.endtime}"</td>
				<td><input type="text" value="${trainFromServer.mile}" name="mile" /></td>
				<td><input type="text" value="${trainFromServer.noseatnumber}"
					name="noseatnumber" /></td>
				<td><input type="text" value="${trainFromServer.bodytype}"
					name="bodytype" /></td>
				<td><input type="text" value="${trainFromServer.type}" name="type" /></td>
				<td><input type="submit" value="点击修改"
					onclick="return confirm('确定要修改吗')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>