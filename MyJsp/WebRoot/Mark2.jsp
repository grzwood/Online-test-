<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Mark2.jsp' starting page</title>
    
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
        url = "Mark3"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "teacherMain.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>

  </head>
  
  <body>
    <h1>评判试卷</h1> 
    <% ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1");%>
    <% String qanda=(String)session.getAttribute("qanda"); %>
    <% String fall=(String)session.getAttribute("fall"); %>
    <% String paper=(String)session.getAttribute("paper"); %>
    <form>
     <table align="left">
     
    	<tr><td>简答题干：&nbsp;<%=qanda %><br></td></tr>
    	<%int i; %>
    	<%for( i=0;i<list1.size();i++){%>
    	<tr><td>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	答案 &nbsp;&nbsp;&nbsp; <%=list1.get(i)[7] %>: 
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;<br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	满分&nbsp;&nbsp;&nbsp; <%=fall %>
    	<br>
    	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	评分<input type="text" name=<%=i%> onkeyup="this.value=this.value.replace(/\D/g, '')" />
    	
    	<% }%>
    	</td></tr>
		<tr><td>
		<input type="submit" value="确认" onclick="handler(1)">
		<input type="submit" value="返回" onclick="handler(2)">
		<input type="hidden" name="paper" value=<%=paper%>>
		<input type="hidden" name="num" value=<%=i%>>
		</td></tr>
    </table>
    </form>
  </body>
</html>
