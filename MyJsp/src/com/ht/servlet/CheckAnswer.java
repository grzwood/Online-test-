package com.ht.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckAnswer
 */
@WebServlet("/CheckAnswer")
public class CheckAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnswer() {
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
		  String username = request.getParameter("username");
		  String answer = request.getParameter("answer");
		  account.setPassword("Íü¼ÇÃÜÂë");
		  account.setUsername(username);
		  DataBaseOperator DBO=DataBaseOperator.getInstance();
		  ArrayList<String []> list = new ArrayList<String []>();
		  String Sqlstring = 
					  "select * from user where user='" + username +  "';";
		  	list= DBO.search(Sqlstring);
			 System.out.println(Sqlstring);
			 account.setType(Integer.parseInt(list.get(0)[4]));
			 if(list.get(0)[3].equals(answer)) {
				 session.setAttribute("account", account);
				 String login_suc = "changePassword.jsp";
				 response.sendRedirect(login_suc);
				 return;
			 }else{
				 String login_fail = "lossPassword.jsp";
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
