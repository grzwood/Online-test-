package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LossPassword
 */
@WebServlet("/LossPassword")
public class LossPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LossPassword() {
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
		ArrayList<String []> list = new ArrayList<String []>();
		String sql = "select * from user where user='"+name+"';";
		list=DBO.search(sql);
		num=list.size();
		//System.out.println(list.get(0)[2]);
			if(num==0){
				out.println("<font color='red'>用户名不存在</font>");
			}else{
				if(list.get(0)[2].equals("1"))
				out.println("<font color='black' size=5>您父亲的名字？</font>");
				else{
					if(list.get(0)[2].equals("2"))
						out.println("<font color='black' size=5>您母亲的名字？</font>");
					else out.println("<font color='black'>未知错误</font>");}
			}
	}

}
