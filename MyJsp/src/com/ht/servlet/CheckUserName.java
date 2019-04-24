package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUserName
 */
@WebServlet("/CheckUserName")
public class CheckUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		//设置请求编码方式
		request.setCharacterEncoding("utf-8");
		//设置响应编码方式
		response.setCharacterEncoding("utf-8");
		//设置响应头信息
		response.setHeader("Content-type", "text/html charset=utf-8");
		//响应输出
		PrintWriter out = response.getWriter();
		out.flush();
		String name = request.getParameter("username");
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=0;
		String sql = "select * from user where user='"+name+"';";
		num= DBO.search(sql).size();
			if(num!=0){
				out.println("<font color='red'>用户名已经存在请重新输入</font>");
			}
		out.println("");
	}

}
