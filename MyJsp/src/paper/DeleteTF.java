package paper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class DeleteTF
 */
@WebServlet("/DeleteTF")
public class DeleteTF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTF() {
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
		String tandf = request.getParameter("tandf");
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=-1;
		String sql="delete from tandf where id = '"+tandf+"';";
		System.out.println(sql);
		num=DBO.updata(sql);
		sql="delete from paper where tandf = '"+tandf+"';";
		DBO.updata(sql);
		if(num<=0) {
			 String login_fail = "question.jsp";
			 response.sendRedirect(login_fail);
			 return;
		 }else{
			 String login_suc = "administratorMain.jsp";
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
