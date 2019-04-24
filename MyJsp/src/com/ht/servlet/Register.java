package com.ht.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		AccountBean account = AccountBean.getInstance();
		account.setPassword(pwd);
		account.setUsername(username);
		
		int num=-1;
		String sql="INSERT INTO user(user,password,question,answer,type)"
				+ "VALUES("+"'"
				+ username+"',ENCODE('javee','"+pwd+"'),'"+question+"','"+answer+"','1');";
		System.out.println(sql);
		num=DBO.updata(sql);
		System.out.println("”√ªß√˚"+username+"   √‹¬Î"+pwd+"     "+num);
		if(num<=0) {
			 String login_fail = "fail.jsp";
			 response.sendRedirect(login_fail);
			 return;
		 }else{
			 session.setAttribute("account", account);
			 String login_suc = "studentMain.jsp";
			 response.sendRedirect(login_suc);
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
