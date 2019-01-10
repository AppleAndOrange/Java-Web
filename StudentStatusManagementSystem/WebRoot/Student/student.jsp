<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'student.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
iframe {
	frameborder: 0;
	scrolling: no;
}
.left{
width:100px;
height:500px;

}
.bottom{
margin-left:10%;
}
.right{
width:800px;
height:200px;
margin-left:100px;
margin-top:-40%;
}
a{
	margin-right:10px;
}
</style>
</head>

<body>
<a href="<%=path%>/RegisterAndLogin/login.jsp">注销</a>
	<iframe src="<%=path%>/Student/index.jsp" width="100%" height="60px"
		frameborder=0 scrolling="no" name="iframe_top"></iframe>
	
	
		<iframe src="<%=path%>/Student/inqueryGrade.jsp" width="1200px" height="500px"
		scrolling="no" frameborder=0 name="iframe_right"></iframe>
	
	
</body>
</html>
