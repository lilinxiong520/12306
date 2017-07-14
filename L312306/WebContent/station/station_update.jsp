<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新车站信息</title>
</head>
<body>
	<h3>更新车站信息</h3>

	<form action="${pageContext.request.contextPath }/station_update.action"
		method="post">
		<table>
			<tr>
				<td>车站编号</td>
				<td>${c.id }<input type="hidden" name="id"
					value="${c.id}"></td>
			</tr>
			<tr>
				<td>车站名</td>
				<td><input type="text" name="name"
					value="${c.name }"></td>
			</tr>
			<tr>
				<td>拼音码</td>
				<td><input type="text" name="pinyin"
					value="${c.pinyin }"></td>
			</tr>
			<tr>
				<td>所属行政区</td>
				<td><input type="text" name="region"
					value="${c.region }"></td>
			</tr>
			<tr>
				<td>车站等级</td>
				<td><input type="text" name="range"
					value="${c.range }"></td>
			</tr>
			<tr>
				<td>所属铁路局</td>
				<td><input type="text" name="company"
					value="${c.company}"></td>
			</tr>
			<tr>
				<td>联系地址</td>
				<td><input type="text" name="address"
					value="${c.address }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="更新"></td>
				<td><input type="reset" value="重置"></td>
			</tr>

		</table>
	</form>

</body>
</html>