<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showPaper.jsp' starting page</title>
    
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
        url = "DoTest"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "studentMain.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>
  
  <body>
   <h1>已发布试卷</h1>
    <%ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1"); %>
    <form>
     <table align="left">
    	
    	<%for(int i=0;i<list1.size();i++){%>
    	<tr><td>选择试卷开始答题</td></tr>
    	<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
    	<tr><td>
    	<input type="radio" name="paper" value=<%=list1.get(i)[0]%>>
    	试卷 &nbsp;&nbsp;&nbsp; <%=list1.get(i)[7] %>: </td></tr>
    	<% }%>
    	<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
    	<tr><td>
    	<input type="submit" value="开始答题" onclick="handler(1)">
    	<input type="submit" value="返回" onclick="handler(2)">
    	</td></tr>
    </table>
    </form>
  </body>
</html>
