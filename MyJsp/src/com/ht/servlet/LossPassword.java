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
		//����������뷽ʽ
		request.setCharacterEncoding("utf-8");
		//������Ӧ���뷽ʽ
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ��Ϣ
		response.setHeader("Content-type", "text/html charset=utf-8");
		//��Ӧ���
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
				out.println("<font color='red'>�û���������</font>");
			}else{
				if(list.get(0)[2].equals("1"))
				out.println("<font color='black' size=5>�����׵����֣�</font>");
				else{
					if(list.get(0)[2].equals("2"))
						out.println("<font color='black' size=5>��ĸ�׵����֣�</font>");
					else out.println("<font color='black'>δ֪����</font>");}
			}
	}

}
