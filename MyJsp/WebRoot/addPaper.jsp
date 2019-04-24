<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addPaper.jsp' starting page</title>
    
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
        url = "AddPaperToDB"; //你要跳的路径
     	}
     	if (value == '2') {
         url = "administratorMain.jsp" //你要跳的路径
     	}
     	document.forms[0].action = url;
     	document.forms[0].submit();}
	</script>
  </head>
  
  <body>
    <h1>题库管理</h1> 
    <%ArrayList<String []> list1=(ArrayList<String []>)session.getAttribute("list1"); %>
    <%ArrayList<String []> list2=(ArrayList<String []>)session.getAttribute("list2"); %>
    <%ArrayList<String []> list3=(ArrayList<String []>)session.getAttribute("list3"); %>
    <form>
     <table align="left">
     	<tr><td>&nbsp;请输入试卷名
     	<input type="text" name="name" required="required"/>
     	</td></tr>
    	<tr><td>&nbsp;请选择一道选择题<br></td></tr>
    	<%for(int i=0;i<list1.size();i++){%>
    	<tr><td>
    	<input type="radio" name="chose" value=<%=list1.get(i)[0]%>>
    	第<%=i+1 %>题: <%=list1.get(i)[1] %></td></tr>
    	<tr><td>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	A:<%=list1.get(i)[3] %>
	    	&nbsp;&nbsp;&nbsp;
	    	B:<%=list1.get(i)[4] %>
	    	&nbsp;&nbsp;&nbsp;
	    	C:<%=list1.get(i)[5] %>
	    	&nbsp;&nbsp;&nbsp;
	    	D:<%=list1.get(i)[6] %>
	    	</td>
    	</tr><%} %>
    	<tr><td>
    	设定分值：<input type="text" required="required" name="choseValue" onkeyup="this.value=this.value.replace(/\D/g, '')" />
    	</td></tr>
    	<tr><td>&nbsp;&nbsp;&nbsp;
    	</td></tr>
    	
    	<tr><td>&nbsp;请选择一道判断题<br></td></tr>
    	<%for(int j=0;j<list2.size();j++){%>
    	<tr><td>
    	<input type="radio" name="tandf" value="<%=list2.get(j)[0]%>">
    	第<%=j+1 %>题:  <%=list2.get(j)[1] %></td></tr> <%} %>  	
    	<tr><td>
    	设定分值：<input type="text" required="required" name="tandfValue"  onkeyup="this.value=this.value.replace(/\D/g, '')" />
    	</td></tr>
    	<tr><td>
    	&nbsp;&nbsp;&nbsp;</td></tr>
    	
    	<tr><td>&nbsp;请选择一道简答题<br></td></tr>
    	<%for(int j=0;j<list3.size();j++){%>
    	<tr><td>
    	<input type="radio" name="qanda" value=<%=list3.get(j)[0]%>>
    	第<%=j+1 %>题: <%=list3.get(j)[1] %></td></tr>   	
    	<%} %>
    	<tr><td>
    	设定分值：<input type="text" name="qandaValue" required="required" onkeyup="this.value=this.value.replace(/\D/g, '')" />
    	</td></tr>
    	<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
		<tr><td>
		<input type="submit" value="添加" onclick="handler(1)">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="返回" onclick="handler(2)">
    </table>
    </form>
  </body>
</html>
