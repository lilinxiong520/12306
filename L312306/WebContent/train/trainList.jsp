<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>列车信息</title>
</head>
<body>
	<h3>列车信息</h3>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>车次代码</td>
			<td>起始站	</td>
			<td>终到站</td>
			<td>始发时间</td>
			<td>终到时间</td>
			<td>里程</td>
			<td>无座票数量</td>
			<td>车辆车体分类</td>
			<td>列车类型</td>
			<td>操作</td>
		</tr>
		<c:forEach var="train" items="${trainListFromServer}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${train.id}</td>
			<td>${train.startstation}</td>
			<td>${train.endstation}</td>
			<td>${train.starttime}</td>
			<td>${train.endtime}</td>
			<td>${train.mile}</td>
			<td>${train.noseatnumber}</td>
			<td>${train.bodytype}</td>
			<td>${train.type}</td>
			<td>
				<a href='${pageContext.request.contextPath}/train_delete.action?id=${train.id}' onclick="return confirm('确定要删除吗');">删除</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='${pageContext.request.contextPath}/train_find_ById.action?id=${train.id}&type1=update'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href='${pageContext.request.contextPath}/train/trainSave.jsp'>增加列车</a>
	<form
		action="${pageContext.request.contextPath }/train_find_findByProperty.action"
		method="post">
		查询条件：
		<select name="propName">
			<option value="id" selected="selected">列车编号</option>
			<option value="startstation" selected="selected">起始站</option>
			<option value="endstation" selected="selected">列车编号</option>
		</select>
		<input type="text" name="propVal" value="K31"> 
		<br/>
		<input type="submit" value="查询" />
	</form>
</body>
</html>