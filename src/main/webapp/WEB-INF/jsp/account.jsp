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
	this account；<br>

	 ${person.id }<br>
	 <span th:text="${person.name}"></span>

</body>
</html>
