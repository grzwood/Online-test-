package paper;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class Mark2
 */
@WebServlet("/Mark2")
public class Mark2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mark2() {
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
		  HttpSession session = request.getSession();
		  DataBaseOperator DBO=DataBaseOperator.getInstance();
		  ArrayList<String []> list1 = new ArrayList<String []>();
		  String qanda = null;
		  String fall = null;
		  String paper = request.getParameter("paper");
		  
		  String Sqlstring1 = "select * from paper where id='"+paper+"';";
		  list1=DBO.search(Sqlstring1);
		  qanda=list1.get(0)[5];
		  fall=list1.get(0)[6];
		  
		  Sqlstring1 = "select * from qanda where id='"+qanda+"';";
		  list1=DBO.search(Sqlstring1);
		  qanda=list1.get(0)[1];
		  
		  
		  Sqlstring1 = "select * from test where paper='"+paper+"'and mark is null;";
		  list1=DBO.search(Sqlstring1);
		  
		  session.setAttribute("qanda", qanda);
		  session.setAttribute("fall", fall);
		  session.setAttribute("list1", list1);
		  session.setAttribute("paper", paper);
		  
		  String login_suc="Mark2.jsp" ;
		  response.sendRedirect(login_suc);
		  return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
