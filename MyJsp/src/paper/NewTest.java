package paper;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.servlet.AccountBean;
import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class NewTest
 */
@WebServlet("/NewTest")
public class NewTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTest() {
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
		  ArrayList<ArrayList<String []>>list2=new  ArrayList<ArrayList<String []>>();
		  
		  ArrayList<ArrayList<String []>> chose = new ArrayList<ArrayList<String []>>();
		  ArrayList<ArrayList<String []>> tandf = new ArrayList<ArrayList<String []>>();
		  ArrayList<ArrayList<String []>> qanda = new ArrayList<ArrayList<String []>>();
		 
		  ArrayList<String []> temper = new ArrayList<String []>();
		  
		  AccountBean AB=AccountBean.getInstance();
		  String name=AB.getUsername();
		  String Sqlstring1 = "select * from test where student='"+name+"';";
		  list1=DBO.search(Sqlstring1);
		  String Sqlstring2=null;
		  
		  for(int i=0;i<list1.size();i++){
			  Sqlstring2 = "select * from paper where id='"+list1.get(i)[2]+"';"; 
			  temper=DBO.search(Sqlstring2);
			  list2.add(DBO.search(Sqlstring2));
			  
			  Sqlstring2 = "select * from chose where id='"+temper.get(0)[1]+"';";
			  chose.add(DBO.search(Sqlstring2));
			  Sqlstring2 = "select * from tandf where id='"+temper.get(0)[3]+"';";
			  tandf.add(DBO.search(Sqlstring2));
			  Sqlstring2 = "select * from qanda where id='"+temper.get(0)[5]+"';";
			  qanda.add(DBO.search(Sqlstring2));
		  }
		  String login_suc="NewTest.jsp";
		  session.setAttribute("list1", list1);
		  session.setAttribute("list2", list2);
		  session.setAttribute("chose", chose);
		  session.setAttribute("tandf", tandf);
		  session.setAttribute("qanda", qanda);
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
