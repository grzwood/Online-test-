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
 * Servlet implementation class GetMark
 */
@WebServlet("/GetMark")
public class GetMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMark() {
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
		  ArrayList<Integer> mark = new ArrayList<Integer>();
		  int sum=0;
		  
		  String Sqlstring1 = "select * from paper ;";
		  list1=DBO.search(Sqlstring1);
		  String Sqlstring2 = null;
		  System.out.println(Sqlstring1);
		  for(int i=0;i<list1.size();i++){
			  Sqlstring2="select * from test where paper='"+list1.get(i)[0]+"';";
			  list2=DBO.search(Sqlstring2);
			  System.out.println(Sqlstring2);
			  for(int j=0;j<list2.size();j++){
				  if(list2.get(j)[10]!=null)
				  sum+=Integer.parseInt(list2.get(j)[10]);
			  }
			  if(list2.size()!=0)sum=sum/list2.size();
			  mark.add(sum);
			  sum=0;
		  }
		  
		  session.setAttribute("list1", list1);
		  session.setAttribute("mark", mark);
		  
		  String login_suc="getMark.jsp" ;
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
