<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lossPassword.jsp' starting page</title>
    
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
        url = "CheckAnswer"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "login.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
 function findUserName(){
 	//创建XMLHttpRequest对象
			var request = new XMLHttpRequest();
			//监听readystate的值的改变事件
			request.onreadystatechange = function (){
				//当readystate的值为4时代表响应已经全部完成
				//alert(request.readyState);
				if(request.readyState == 4){
					var data = request.responseText;
					var ulab = document.getElementById("ulab");
					ulab.innerHTML = data;
				}
			};
			//打开请求
			request.open("post","LossPassword",true);
		    //设置请求头信息
		    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		    var username = document.getElementById("one").value;
		    //发送请求
		    request.send("username=" + username);
 }
</script>
  </head>
  
  <body>
   	<h1>找回密码</h1>
   	<form action="CheckAnswer">
   		输入用户名*：<input type="text" name="username" id="one" required="required" onkeyup="findUserName()"/>
   		 <br><br>验证问题：<label id = "ulab"></label><br><br><br>
   		输入答案*：<input type="text" name="answer" id="two" required="required" /><br><br>
   		<input type="submit" name="ok" value="确认" align="middle" />
   		<input type="submit" name="back" value="返回" align="middle" onclick="handler(2)"/>
   	</form>
  </body>
</html>
