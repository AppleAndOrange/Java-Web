<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'inqueryGrade.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		form{
			margin:5% 25%;
		}
		input{
			margin-left:20px;
		}
		
	</style>
  </head>
  	
  	
  <body>
    <div>
  		<form action="ShowData" method="post">
  			选择学年<select class="drop_down_box" name="time">
  			<option value="2014next">2014下学期</option>
  			<option value="2015privious">2015上学期</option>
  			<option value="2015next">2015下学期</option>
  			<option value="2016privious">2016上学期</option>
  			<option value="2016next">2016下学期</option>
  			<option value="2017privious">2017上学期</option>
  			<option value="2017next">2017下学期</option>
  			<option value="2018privious">2018上学期</option>
	  		</select>
	  		科目<input type="text" name="subject" class="subject"/>
  			<input type="submit" value="查询"/>
  		</form><br/>
		  		
  	</div>
  </body>
</html>
