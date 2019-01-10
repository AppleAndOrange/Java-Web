<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'query.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form name="fm" method="post">
    	班级：<input type="text" name="class">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	学号：<input type="text" name="account">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" name="query" value="查询" onclick="document.fm.action='<%=path%>/QueryData';document.fm.submit();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" name="export" value="导出" onclick="document.fm.action='<%=path%>/ExportData';document.fm.submit();">
    </form>
  </body>
</html>
