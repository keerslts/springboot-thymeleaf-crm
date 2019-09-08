<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>test Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
table {
	width: 80%;
	border: 1px solid #ccc;
	margin-left: 10%;
	text-align: center;
}
table thead tr{
	border: 1px solid #ccc;
	background: yellow;
	height: 30px;
}
table tbody td{
	border: 1px solid #ccc;
	height: 25px;
}
.text1{
	font-size:36px;
	text-align: center
}
</style>
</head>

<body>
	<br />
	<h1 style="text-align: center;width:100%;">CRM管理系统</h1>
	<br />
	<br />
	<hr />
	<br />
	<br />
	<br />

	<div class='text1'>
	账号信息管理	<input style="width:100px;height:30px" type="button" value="进入" onclick="window.location.href='account'" />
	<br />
	学生课时录入	<input style="width:100px;height:30px" type="button" value="进入" onclick="window.location.href='getAllStudents.do'" />
	<br />
	学生信息修改	<input style="width:100px;height:30px" type="button" value="进入" onclick="window.location.href='updateStudentsInfo.do'" />
	</div>
</body>
</html>
