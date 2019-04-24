<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addT&F.jsp' starting page</title>
    
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
    <h1>判断题添加</h1> <br>
    <form action="AddTandF">
   	  题干  *:<textarea name="question" row=3 required="required"  style="width: 406px; "></textarea><br><br>
   	 正确答案 *  :
   	 <br>正确:<input type="radio"  name="answer" value="T" checked/> 
   	 	   错误:<input type="radio"  name="answer" value="F"/><br><br>
   	 <input type="submit" name="add" value="添加" align="middle" ><br><br>
   	 <a href=administratorMain.jsp>返回</a>
    </form>
  </body>
</html>
