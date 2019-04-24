package com.ht.servlet;

//////用户名密码验证类

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckAccount extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	   throws ServletException, IOException {
	  doGet(req,resp);
	 }
	 @Override
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
	   throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
		 HttpSession session = req.getSession();
	  AccountBean account = AccountBean.getInstance();
	  String username = req.getParameter("username");
	  String pwd = req.getParameter("pwd");
	  account.setPassword(pwd);
	  account.setUsername(username);
	  DataBaseOperator DBO=DataBaseOperator.getInstance();
	 /* if((username == null)||(pwd == null)){
		  return ;
	  }*/
	  int num=0;
	  ArrayList<String []> list = new ArrayList<String []>();
	  String Sqlstring = 
				  "select * from user where user='" + username + "'and password=ENCODE('javee','" + pwd + "');";
	  list=DBO.search(Sqlstring);
	  num=list.size();
	  System.out.println(Sqlstring+"      "+Integer.parseInt(list.get(0)[4]));
	  account.setType(Integer.parseInt(list.get(0)[4]));
	  account.setUsername(list.get(0)[0]);
	  System.out.println(num);
	  if(num==0) {
			String login_fail = "fail.jsp";
			resp.sendRedirect(login_fail);
			return;
		 }else{
			 int m=account.getType();
			 session.setAttribute("account", account);
			 String login_suc = null ;
			 if(m==1){login_suc = "studentMain.jsp";}
			 if(m==2){login_suc = "teacherMain.jsp";}
			 if(m==3){System.out.println("yes");login_suc = "administratorMain.jsp";}
			 resp.sendRedirect(login_suc);
			 return;
		 }
			 
	 }
	 
}
