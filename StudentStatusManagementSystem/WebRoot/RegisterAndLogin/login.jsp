<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/CSS/login.css" />
	<script type="text/javascript">
		function refreshCode() {
	    var codeImg = document.getElementById("codeImg");
	    var d = new Date();
	    codeImg.src = "ValidCodeServelet?s="+d;
	    }
	</script>
  </head>
  
  <body>
  
    <img alt="绵阳师范学院标签" src="<%=path %>/Image/mslogo.jpg" class="logo"/><br/>
    <img alt="绵阳师范学院标签" src="<%=path %>/Image/sysmbol.jpg" class="sysmbol"/>
    <form action="<%=path%>/RegisterAndLogin/Login_login.action">	
    	账&nbsp;&nbsp;&nbsp;号 	<input type="text" name="account" class="account"/><br/>
    	密&nbsp;&nbsp;&nbsp;码	<input type="password" name="loginPassword" class="password"/><br/>
    	验证码  <input type="text" name="randNumber" class="randNumber"/>&nbsp;
    	<img id="codeImg" src="ValidCodeServelet" onclick="refreshCode()" class="valid"/><br/>
    	<input type="submit" value="提交" class="login"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </form>
  </body>
</html>
