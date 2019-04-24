<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doTest.jsp' starting page</title>
    
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
	var chose=document.getElementById("chose").value;
	var TandF=document.getElementById("TandF").value;
	var qanda=document.getElementById("qanda").value;
	if(chose==null){alert("选择题未作答"); return false;}
	if(TandF==null){alert("判断题未作答"); return false;}
	if(qanda==null){alert("简答题未作答"); return false;}
	return true;
	}
	</script>
  </head>
  
  <body>
    
    <%ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1"); %>
    <%String [] chose=(String [])session.getAttribute("chose"); %>
    <%String [] TF=(String [])session.getAttribute("TF"); %>
    <%String [] QA=(String [])session.getAttribute("QA"); %>
    <h1>试卷&nbsp;&nbsp;&nbsp; <%=list1.get(0)[7] %></h1> 
    <form action=InputTest onsubmit="return check()">
     <table align="left">
     
    	<tr><td>&nbsp;请作答<br></td></tr>
    	
    	<%for(int i=0;i<list1.size();i++){%>
    	<tr><td>
    	&nbsp;
    	</td></tr>
    	<tr><td style="width: 928px; ">
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	选择题:<%=chose[i*5] %><br>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<input type="radio" name="chose" value="A" ID="chose">A:<%=chose[i*5+1] %>
	    	<input type="radio" name="chose" value="B" ID="chose">B:<%=chose[i*5+2] %>
	    	<input type="radio" name="chose" value="C" ID="chose">C:<%=chose[i*5+3] %>
	    	<input type="radio" name="chose" value="D" ID="chose">D:<%=chose[i*5+4] %>
	    	</td></tr><tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	判断题:<%=TF[i] %></td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<input type="radio" name="TandF" value="T" ID="TandF">正确
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<input type="radio" name="TandF" value="F" ID="TandF">错误
	    	</td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	</td></tr>
	    <tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	简答题:<%=QA[i] %></td></tr>
	    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<textarea name="qanda" row=3 required="required" id="qanda" style="width: 406px; "></textarea>
	    	</td></tr>
    	<%} %><tr><td></td></tr>
    	<tr><td>
    	<input type="hidden" name="paper" value=<%=list1.get(0)[0]%>>
    	<input type="submit" value="交卷" >
    	</td></tr>
    </table>
    </form>
  </body>
</html>
