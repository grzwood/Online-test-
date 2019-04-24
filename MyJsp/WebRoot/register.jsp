<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
 function handler(value){
	  	var url = "";
    	 if (value == '1') {
        url = "Register"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "login.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
  function judge() {
      var look=document.getElementById("two").value;
      var re = /^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$/;
      if(!re.test(look)){
          alert("您输入的密码格式有误！请输入至少为8位的字母与数字组合！");
          return false;
      }else {
          return true;
      }    
  }
  function check(){
   		var look=document.getElementById("four").value;
   		var look1=document.getElementById("two").value;
   		var look2=document.getElementById("three").value;
   		if(look=="0"){
          alert("请选择一个验证问题");
          return false;
      }else {
      if(look1!=look2){ 
     	 alert("两次密码不同");
     	 return false;}
      	 return true;
      }    
  }
  function checkUserName(){
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
			request.open("post","CheckUserName",true);
		    //设置请求头信息
		    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		    var username = document.getElementById("one").value;
		    //发送请求
		    request.send("username=" + username);
  }
 </script>
  </head>
  <body>
    	<h1>新用户注册 </h1>
    	<form  action="Register" onsubmit="return (judge()&&check())">  
    	用户名  *:<input type="text" name="username" id="one" required="required" onkeyup="checkUserName()"/><label id = "ulab"></label><br><br>  
   		 输入密码*: <input type="password" name="pwd" id="two" required="required"/>(字母与数字组合，8位以上)  <br><br> 
   		确认密码*:<input type="password" name="repwd" id="three" required="required"/>  <br><br> 
   		验证问题*:<select name="question"  id="four">
   				<optgroup label='验证问题'></optgroup>
   				<option value="0">-请选择-</option>     
  				<option value="1" <c:if test="${'1' eq curStatus}"></c:if> >您父亲的名字？</option>     
  				<option value="2" <c:if test="${'2' eq curStatus}"></c:if> >您母亲的名字？</option>  
 				</select><br><br> 
 		问题答案*:<input type="text" name="answer" required="required"><br><br>
    <input type="submit" name="register" value="注册" align="middle""> 
    <input type="submit" name="login" value="返回" align="middle" onclick="handler(2)"> 
    </form>  
  </body>
</html>
