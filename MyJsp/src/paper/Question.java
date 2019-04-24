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
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
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
	  ArrayList<String []> list2 = new ArrayList<String []>();
	  ArrayList<String []> list3 = new ArrayList<String []>();
	  String Sqlstring1 = "select * from chose ;";
	  String Sqlstring2 = "select * from tandf ;";
	  String Sqlstring3 = "select * from qanda ;";
	  list1=DBO.search(Sqlstring1);
	  list2=DBO.search(Sqlstring2);
	  list3=DBO.search(Sqlstring3);
	  session.setAttribute("list1", list1);
	  session.setAttribute("list2", list2);
	  session.setAttribute("list3", list3);
	  String login_suc="question.jsp" ;
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
