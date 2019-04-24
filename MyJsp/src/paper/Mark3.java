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
 * Servlet implementation class Mark3
 */
@WebServlet("/Mark3")
public class Mark3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mark3() {
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
		  ArrayList<String []> chose = new ArrayList<String []>();
		  ArrayList<String []> tandf = new ArrayList<String []>();
		  ArrayList<String []> list2 = new ArrayList<String []>();
		  AccountBean ab= AccountBean.getInstance();
		  String paper = request.getParameter("paper");
		  String choseMark="0";
		  String tandfMark="0";
		  String qandaMark="0";
		  
		  String Sqlstring1 = "select * from paper where id='"+paper+"';";
		  list2=DBO.search(Sqlstring1);
		  
		  Sqlstring1 = "select * from chose where id='"+list2.get(0)[1]+"';";
		  chose=DBO.search(Sqlstring1);
		  
		  Sqlstring1 = "select * from tandf where id='"+list2.get(0)[3]+"';";
		  tandf=DBO.search(Sqlstring1);
		  
		  Sqlstring1 = "select * from test where paper='"+paper+"'and QandAMark is null;";
		  list1=DBO.search(Sqlstring1);
		  System.out.println(Sqlstring1);
		  System.out.println(list1.size());
		  for(int i=0;i<list1.size();i++){
			  
			  int x=0;
			  int mark;
			  if(list1.get(i)[3].equals(chose.get(0)[2])) choseMark=list2.get(0)[2];
			  if(list1.get(i)[5].equals(tandf.get(0)[2])) tandfMark=list2.get(0)[4];
			  qandaMark=request.getParameter( String.valueOf(i)	);
			  mark=Integer.parseInt(choseMark)+Integer.parseInt(tandfMark)+Integer.parseInt(qandaMark);
			  Sqlstring1 = "update test set choseMark="+choseMark+",tandfMark="+tandfMark
			  		+ ",qandaMark="+qandaMark+",mark="+mark+",teacher='"+ab.getUsername()+"' where id="+list1.get(i)[0]+" and mark is null ;";
			  System.out.println(Sqlstring1);
			  x= DBO.updata(Sqlstring1);
			  System.out.println(x);
			  choseMark="0";
			  tandfMark="0";
			  qandaMark="0";
			  if(x==0) break;
		  }
		  
		  String login_suc="teacherMain.jsp" ;
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
