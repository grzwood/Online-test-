<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
        url = "AddPaper"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "DeletePaper" //你要跳的路径
     	}
     	if (value == '3') {
         url = "administratorMain.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>
  
  <body>
  <h1>试卷管理</h1> 
    <%ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1"); %>
    <%String [] chose=(String [])session.getAttribute("chose"); %>
    <%String [] TF=(String [])session.getAttribute("TF"); %>
    <%String [] QA=(String [])session.getAttribute("QA"); %>
    <form>
     <table align="left">
     
    	<tr><td>&nbsp;已有试卷<br></td></tr>
    	
    	<%for(int i=0;i<list1.size();i++){%>
    	<tr><td>
    	<input type="radio" name="paper" value=<%=list1.get(i)[0]%>>
    	试卷 &nbsp;&nbsp;&nbsp; <%=list1.get(i)[7] %>: </td></tr>
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	选择题:<%=chose[i*5] %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	A:<%=chose[i*5+1] %>
	    	B:<%=chose[i*5+2] %>
	    	C:<%=chose[i*5+3] %>
	    	D:<%=chose[i*5+4] %>
	    	</td></tr><tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[2]%>
	    	<tr><td>
	    	</td></tr>
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	判断题:<%=TF[i] %></td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[4]%>
	    	</td></tr>
	    	<tr><td></td></tr>
	    <tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	简答题:<%=QA[i] %></td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[6]%>
	    	</td></tr>
    	<%} %><tr><td></td></tr>
    	<tr><td>
    	
    	<input type="submit" value="添加试卷" onclick="handler(1)">
    	<input type="submit" value="删除试卷" onclick="handler(2)">
    	
    	</td></tr>
		<tr><td>
		<input type="submit" value="返回" onclick="handler(3)"></td></tr>
    </table>
    </form>
  </body>
</html>
