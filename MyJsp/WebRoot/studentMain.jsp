<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ht.servlet.AccountBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	  function handler(value){
	  	var url = "";
    	 if (value == '1') {
        url = "StudentMain"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "NewTest" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>
  
  <body>
    <%  
   AccountBean account = AccountBean.getInstance();  
    %>  
    <h1>欢迎<%= account.getUsername()%> 同学 </h1> 
    <form>
    <input type="submit" name="question" value="选择考试" align="middle" onclick="handler(1)"/>        
    
    <input type="submit" name="paper" value="已考信息" align="middle" onclick="handler(2)"/>
    <br><br>
    <a href=login.jsp>登出</a>
    </form>
  </body>
</html>
