<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NewTest.jsp' starting page</title>
    
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
        url = "studentMain.jsp"; //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>
  
  <body>
   <h1>已作答试卷</h1> 
    <%ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1"); %>
    <%ArrayList<ArrayList<String []>> list2=(ArrayList<ArrayList<String []>>)session.getAttribute("list2"); %>
    <%ArrayList<ArrayList<String []>> chose=(ArrayList<ArrayList<String []>>)session.getAttribute("chose"); %>
    <%ArrayList<ArrayList<String []>> tandf=(ArrayList<ArrayList<String []>>)session.getAttribute("tandf"); %>
    <%ArrayList<ArrayList<String []>> qanda=(ArrayList<ArrayList<String []>>)session.getAttribute("qanda");%> 
    <form>
     <table align="left">
     
    	<tr><td>&nbsp;已作答试卷<br></td></tr>
    	
    	<%for(int i=0;i<list1.size();i++){%>
    	<tr><td>
    	试卷 &nbsp;<%=list2.get(i).get(0)[7] %>: </td></tr>
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	选择题:<%=chose.get(i).get(0)[1] %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	A:<%=chose.get(i).get(0)[3]  %>
	    	B:<%=chose.get(i).get(0)[4]  %>
	    	C:<%=chose.get(i).get(0)[5]  %>
	    	D:<%=chose.get(i).get(0)[6]  %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	你的选择<%=list1.get(i)[3]  %>
	    	</td></tr><tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[4]%>
	    	<tr><td>
	    	</td></tr>
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	判断题:<%=tandf.get(i).get(0)[1] %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	你的选择<%=list1.get(i)[5]  %>
	    	<br> </td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[6]%>
	    	</td></tr>
	    	<tr><td></td></tr>
	    <tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	简答题:<%=qanda.get(i).get(0)[1] %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	你的答案<%=list1.get(i)[7]  %>
	    	</td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	分值：<%=list1.get(i)[8]%>
	    	</td></tr>
    	<%} %><tr><td></td></tr>
		<tr><td>
		<input type="submit" value="返回" onclick="handler(1)"></td></tr>
    </table>
    </form>
  </body>
</html>
