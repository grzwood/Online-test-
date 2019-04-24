package paper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class AddTandF
 */
@WebServlet("/AddTandF")
public class AddTandF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTandF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html charset=utf-8");
		
		String question = request.getParameter("question");
		question =new String(question.getBytes("ISO-8859-1"),"UTF-8");
		
		String answer=request.getParameter("answer");
		answer =new String(answer.getBytes("ISO-8859-1"),"UTF-8");
		
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=-1;
		String sql="INSERT INTO tandf(question,answer)"
				+ "VALUES("+"'"
				+ question+"','"+answer+"');";
		System.out.println(sql);
		num=DBO.updata(sql);
		if(num<=0) {
			 String login_fail = "fail.jsp";
			 response.sendRedirect(login_fail);
			 return;
		 }else{
			 String login_suc = "addT&F.jsp";
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
