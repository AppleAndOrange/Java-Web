<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/CSS/register.css">


  </head>
  
  <body>
  	<a href="<%=path%>/RegisterAndLogin/login.jsp">注销</a>
  	<h1>绵阳师范学院人员管理</h1>
     <form name="fm">
     	帐&nbsp;&nbsp;&nbsp;号&nbsp;<input type="text" name="user.account"><br/>
     	姓&nbsp;&nbsp;&nbsp;名&nbsp;<input type="text" name="user.userName"><br/>
     	密&nbsp;&nbsp;&nbsp;码&nbsp;<input type="text" name="user.password"><br/>
     	职&nbsp;&nbsp;&nbsp;能&nbsp;<input type="text" name="user.type"><br/>
     	班&nbsp;&nbsp;&nbsp;级&nbsp;<input type="text" name="user.cla"><br/>
     	<input type="button" name="add" value="增加" onclick="document.fm.action='<%=path%>/RegisterAndLogin/User_register.action';document.fm.submit();"/>
     	<input type="button" name="update" value="修改" onclick="document.fm.action='<%=path%>/RegisterAndLogin/User_update.action';document.fm.submit();"/>
     	<input type="button" name="delete" value="删除" onclick="document.fm.action='<%=path%>/RegisterAndLogin/User_delete.action';document.fm.submit();"/>
     	<!-- <div>
     		<s:fielderror></s:fielderror>显示出错信息
     	</div> -->
     </form>
  </body>
</html>
