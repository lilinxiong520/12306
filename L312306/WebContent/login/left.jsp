<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">

		d = new dTree('d');  /* 创建一个树的根 */
		d.add(0,-1,'系统菜单树');  /*  根元素的名称：系统菜单树*/
		/*  参数1：当 前目录的标识名   参数2：父级目录的标识  参数3：当前目录显示的名称,参数4：点击此目录跳转的页面地址,参数5：跳转页面显示的位置*/
		d.add(1,0,'人员管理','','','mainFrame');
		d.add(11,1,'管理员信息表','${pageContext.request.contextPath}/admin_findAll.action','','mainFrame');
		d.add(12,1,'用户信息表','${pageContext.request.contextPath}/uuser_findAll.action','','mainFrame');
		
	    d.add(2, 0, '票务管理', '' ,'', 'mainFrame' );
		d.add(21, 2, '票价率相关', '${pageContext.request.contextPath}/price_findAll.action' ,'', 'mainFrame' );
		d.add(22, 2, '递远递减率', '${pageContext.request.contextPath}/journeyrate_findAll.action' ,'', 'mainFrame' );
		
		d.add(3,0,'计划管理','','','mainFrame');
		d.add(31, 3, '列车编组管理', '${pageContext.request.contextPath}/carriage_findAll.action' ,'', 'mainFrame' );
		d.add(32, 3, '线路管理', '${pageContext.request.contextPath}/route_findAll.action' ,'', 'mainFrame' );
		d.add(33, 3, '席位信息', '${pageContext.request.contextPath}/seat_findAll.action' ,'', 'mainFrame' );
		d.add(34, 3, '计划信息', '${pageContext.request.contextPath}/plan_findAll.action' ,'', 'mainFrame' );
		
		d.add(4,0,'基础数据管理','','','mainFrame');
		d.add(41, 4, '车票信息表', '${pageContext.request.contextPath}/ticket_findAll.action' ,'', 'mainFrame' );
		d.add(42, 4, '订单信息表', '${pageContext.request.contextPath}/orders_findAll.action' ,'', 'mainFrame' );
		d.add(43, 4, '旅程区段', '${pageContext.request.contextPath}/journey_findAll.action' ,'', 'mainFrame' );
		document.write(d);

	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
