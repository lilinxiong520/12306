<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情页面</title>
<link href="static/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="static/jquery.js"></script>

<script src="static/bootstrap.min.js"></script>

	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<table class="table" style="font-size: 20px;width: 50%;margin-left: 25%">
				<thead>
					<tr>
						<th>
							订单详情页面&nbsp;&nbsp;&nbsp;&nbsp;
							查看<font color="blue">${uuser.name}</font>的订单
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							订单编号
						</td>
						<td>
							${ordersvoFormService.orders.id}
						</td>
					</tr>
					<tr class="success">
						<td>
							车次
						</td>
						<td>
							${ordersvoFormService.train.id}
						</td>
						
					</tr>
					<tr class="error">
						<td>
							乘车日期
						</td>
						<td>
							${ordersvoFormService.ticket.tdate}
						</td>
					</tr>
					<tr class="warning">
						<td>
							所在车厢
						</td>
						<td>
							${ordersvoFormService.ticket.gnumber}
						</td>
					</tr>
					<tr class="info">
						<td>
							座位号
						</td>
						<td>
							${ordersvoFormService.ticket.seatnumber}
						</td>
					</tr>
					
					<tr>
						<td>
							乘车起始站/<font style="color: blue;font-weight: bold;">出发时间</font>
						</td>
						<td>
							${ordersvoFormService.ticket.startstation}/
							(当天)
							<font style="color: blue;font-weight: bold;">
							${ordersvoFormService.startTime}</font>
						</td>
					</tr>
					<tr class="success">
						<td>
							乘车结束站/<font style="color: blue;font-weight: bold;">到达时间</font>
						</td>
						<td>
							${ordersvoFormService.ticket.endstation}/
							(当天)
							<font style="color: blue;font-weight: bold;">
							${ordersvoFormService.endTime}</font>
						</td>
						
					</tr>
					<tr class="error">
						<td>
							票价
						</td>
						<td>
							${ordersvoFormService.ticket.price}
						</td>
					</tr>
					<tr class="warning">
						<td>
							乘客姓名
						</td>
						<td>
							${ordersvoFormService.ticket.uname}
						</td>
					</tr>
					<tr class="info">
						<td>
							乘客类型
						</td>
						<td>
							${ordersvoFormService.ticket.utype==1?"重点乘客":"一般乘客"}
						</td>
					</tr>
					
					<tr>
						<td>
							身份证号
						</td>
						<td>
							${ordersvoFormService.ticket.uidnumber}
						</td>
					</tr>
					<tr class="success">
						<td>
							购买方式
						</td>
						<td>
							${ordersvoFormService.ticket.saletype==1?"网购":"车站购买"}
						</td>
						
					</tr>
					<tr class="error">
						<td>
							购买时间
						</td>
						<td>
							${ordersvoFormService.ticket.saletime}
						</td>
					</tr>
					<tr class="warning">
						<td>
							车票状态
						</td>
						<td>
							${ordersvoFormService.ticket.status==1?"未取票":"已取票"}
						</td>
					</tr>
					<tr class="info">
						<td>
							车票退改情况
						</td>
						<td>
							${ordersvoFormService.ticket.revisetime==1?"未改签":""}
							${ordersvoFormService.ticket.revisetime==2?"已改签":""}
							${ordersvoFormService.ticket.revisetime==0?"已退票":""}
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"> 
						<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary btn-large" type="button">继续购票</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-primary btn-large" type="button" 
						href='${pageContext.request.contextPath}/
						ticket_out.action?id=${ordersvoFormService.orders.id}'
						onclick="return confirm('您确定要退票吗?')">退票</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-primary btn-large" type="button"
						href='${pageContext.request.contextPath}/ticket_modify.action?id=${ordersvoFormService.orders.id}'
						>车票改签</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>