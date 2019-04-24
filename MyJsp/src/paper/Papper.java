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
 * Servlet implementation class Papper
 */
@WebServlet("/Papper")
public class Papper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Papper() {
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
	  
	  String Sqlstring1 = "select * from paper ;";
	  list1=DBO.search(Sqlstring1);
	  String [] chose = new String [list1.size()*5] ;
	  String [] TF =new String [list1.size()] ;
	  String [] QA = new String [list1.size()] ;
	  
	  for(int i=0;i<list1.size();i++){
	  String Sqlstring2 = "select * from chose where id='"+list1.get(i)[1]+" ';";
	  list2=DBO.search(Sqlstring2);
	 
	  chose[i*5]=list2.get(0)[1].toString();
	  chose[i*5+1]=list2.get(0)[3].toString();
	  chose[i*5+2]=list2.get(0)[4].toString();
	  chose[i*5+3]=list2.get(0)[5].toString();
	  chose[i*5+4]=list2.get(0)[6].toString();
	 // System.out.println(chose[i*5+4]);
	  Sqlstring2 = "select * from tandf where id='"+list1.get(i)[3]+"' ;";
	  list2=DBO.search(Sqlstring2);
	  TF[i]=list2.get(0)[1];
	  Sqlstring2 = "select * from qanda where id='"+list1.get(i)[5]+"' ;";
	  list2=DBO.search(Sqlstring2);
	  QA[i]=list2.get(0)[1];
	  }
	  session.setAttribute("list1", list1);
	  session.setAttribute("chose", chose);
	  session.setAttribute("TF", TF);
	  session.setAttribute("QA", QA);
	  String login_suc="paper.jsp" ;
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
