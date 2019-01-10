<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OperatorGrade.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/CSS/OperatorGrade.css">

  </head>
  
  <body>
     <div class="operator">
     	<form name="fm" method="post">
     		学号<input type="text" name="account"/><br/>
	     	姓名<input type="text" name="name"/><br/>
	     	科目<input type="text" name="subject"><br/>
	     	班级<input type="text" name="cla"><br/>
	     	成绩<input type="text" name="grade"/><br/>
	     	<input type="button" name="add" value="增加" onclick="document.fm.action='<%=path%>/RegisterAndLogin/Grade_addGrade.action';document.fm.submit();"/>
	     	<input type="button" name="delete" value="删除" onclick="document.fm.action='<%=path%>/RegisterAndLogin/Grade_deleteGrade.action';document.fm.submit();"/>
	     	<input type="button" name="update" value="修改" onclick="document.fm.action='<%=path%>/RegisterAndLogin/Grade_updateGrade.action';document.fm.submit();"/>
	     	<input type="button" name="select" value="查询" onclick="window.location.href='<%=path%>/Teacher/query.jsp'"/><br/>
	     	<input type="button" name="import" value="导入" onclick="document.fm.action='<%=path%>/ImportData';document.fm.submit();"/>
     	</form>
     </div>
  </body>
</html>
