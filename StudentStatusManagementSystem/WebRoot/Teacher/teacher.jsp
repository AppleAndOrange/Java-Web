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

<title>My JSP 'teacher.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path%>/CSS/teacher.css">
<style type="text/css">
iframe {
	frameborder: 0;
	scrolling: no;
}

.iframe_right {
	float: left;
}
.bottom{
	margin:0px 200px;
}
</style>
</head>

<body>
<a href="<%=path%>/RegisterAndLogin/login.jsp">注销</a>
	<iframe src="<%=path%>/Teacher/index.jsp" width="100%" height="60px"
		margin-top="0px" frameborder=0 scrolling="no" name="iframe_top"></iframe>
	<div class="bottom">
		
		<iframe src="<%=path%>/Teacher/OperatorGrade.jsp" width="700px"
			height="600px" scrolling="no" frameborder=0 name="iframe_right"></iframe>
	</div>
</body>
</html>
