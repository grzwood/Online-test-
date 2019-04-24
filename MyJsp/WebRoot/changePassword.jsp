<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function check(){
   		var look1=document.getElementById("two").value;
   		var look2=document.getElementById("three").value;
   		var re = /^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$/;
      	if(!re.test(look1)){
          	alert("您输入的密码格式有误！请输入至少为8位的字母与数字组合！");
          	return false;
      	}else {
      	 	if(look1!=look2){ 
     	 		alert("两次密码不同");
     	 		return false;}
          	else return true;
      	}    
     
    }    
</script>
  </head>
  
  <body>
    <h1>更改密码</h1> <br>
    <form action="ChangePassword" onsubmit="return check()">
     	输入密码*: <input type="password" name="pwd" id="two" required="required"/>(字母与数字组合，8位以上)  <br><br> 
   		确认密码*:<input type="password" name="repwd" id="three" required="required" />  <br><br>
   		<input type="submit" name="ok" value="确认" align="middle" > 
    </form>
  </body>
</html>
