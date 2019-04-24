package paper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class AddQandA
 */
@WebServlet("/AddQandA")
public class AddQandA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQandA() {
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
		String sql="INSERT INTO qanda(question)"
				+ "VALUES("+"'"
				+ question+"');";
		System.out.println(sql);
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=-1;
		
		num=DBO.updata(sql);
		if(num<=0) {
			 String login_fail = "fail.jsp";
			 response.sendRedirect(login_fail);
			 return;
		 }else{
			 String login_suc = "addQandA.jsp";
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
