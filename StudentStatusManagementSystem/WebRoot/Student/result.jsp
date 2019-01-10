<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		td{
			width:200px;
			height:50px;
		}
		body{
			margin-left:150px;
			margin-top:-40%;
		}
	</style>
  </head>
  
  <body>
  <%ResultSet resultSet=(ResultSet)session.getAttribute("result"); %>
    <table>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>成绩</td>
			</tr>
			<tr>
				<td><%=resultSet.getString(2) %></td>
				<td><%=resultSet.getString(6) %></td>
				<td><%=resultSet.getString(5) %></td>
			</tr>
			<%while(resultSet.next()){ %>
				<tr>
				<td><%=resultSet.getString(2) %></td>
				<td><%=resultSet.getString(6) %></td>
				<td><%=resultSet.getString(5) %></td>
			</tr>
			<%} %>
		</table>
  </body>
</html>
