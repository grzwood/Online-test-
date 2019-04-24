package com.ht.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		  AccountBean account = AccountBean.getInstance();
		  account = (AccountBean) request.getSession().getAttribute("account");
		  String username=account.getUsername();
		  System.out.println(username);
		  String password = request.getParameter("pwd");
		  account.setPassword(password);
		  DataBaseOperator DBO=DataBaseOperator.getInstance();
		  if((username == null)||(password == null)){
			  return ;
		  }
		  int num=0;
		  String Sqlstring = "update user set password=ENCODE('javee','"+password+"') where user='" + username +  "';";
		  	num= DBO.updata(Sqlstring);
			 if(num==1) {
				 session.setAttribute("account", account);
				 String login_suc ;

				 if(account.getType()==1){
					 login_suc = "studentMain.jsp";}
				 else{
					 if(account.getType()==2){login_suc = "teacherMain.jsp";}
					 else{
						 if(account.getType()==3){login_suc = "administratorMain.jsp";}
						 else login_suc = "fail.jsp";}}
				 response.sendRedirect(login_suc);
				 return;
			 }else{
				 String login_fail = "fail.jsp";
				 response.sendRedirect(login_fail);
				 return;
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
