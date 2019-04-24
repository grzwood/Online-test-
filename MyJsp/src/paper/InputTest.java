package paper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.servlet.AccountBean;
import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class InputTest
 */
@WebServlet("/InputTest")
public class InputTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputTest() {
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
		String paper = request.getParameter("paper");
		String chose = request.getParameter("chose");
		String tandf = request.getParameter("TandF");
		String qanda = request.getParameter("qanda");
		AccountBean AB=AccountBean.getInstance();
		String name=AB.getUsername();
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=-1;
		String sql="INSERT INTO test(student,paper,chose,TandF"
				+ ",QandA)"
				+ "VALUES('"+name+"','"+paper+"','"+chose+"','"+tandf+"','"+qanda+"')";
		System.out.println(sql);
		num=DBO.updata(sql);
		System.out.println(num);
		if(num<=0) {
			 String login_fail = "doTest.jsp";
			 response.sendRedirect(login_fail);
			 return;
		 }else{
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
