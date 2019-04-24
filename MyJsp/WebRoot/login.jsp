<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'login.jsp' starting page</title>  
      
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
        url = "login"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "register.jsp" //你要跳的路径
     	}
     	if (value == '3') {
         url = "lossPassword.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>  
    	
  <body>  
    	<h1>用户登录 </h1>
     <form >  
    	用户名:<input type="text" name="username"><br><br>  
   		 密码:<input type="password" name="pwd">  <br>
    <br>  
    <input type="submit" name="login" value="登录" align="middle" onclick="handler(1)"/>     
    <input type="submit" name="register" value="注册" align="middle" onclick="handler(2)"/>  
    <input type="submit" value="忘记密码" align="middle" onclick="handler(3)"/> 
    </form> 
  </body>  
</html>  