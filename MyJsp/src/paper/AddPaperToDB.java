package paper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.servlet.DataBaseOperator;

/**
 * Servlet implementation class AddPaperToDB
 */
@WebServlet("/AddPaperToDB")
public class AddPaperToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaperToDB() {
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
		
		String chose = request.getParameter("chose");
		String tandf = request.getParameter("tandf");
		String qanda = request.getParameter("qanda");
		String choseValue=request.getParameter("choseValue");
		String tandfValue=request.getParameter("tandfValue");
		String qandaValue=request.getParameter("qandaValue");
		
		String name=request.getParameter("name");
		name =new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		DataBaseOperator DBO=DataBaseOperator.getInstance();
		int num=-1;
		String sql="INSERT INTO paper(chose,choseValue,TandF,TandFValue"
				+ ",QandA,QandAValue,name)"
				+ "VALUES('"+chose+"','"+choseValue+"','"+tandf+"','"+tandfValue+"','"+qanda+"','"
						+ qandaValue+"','"+name+"');";
		System.out.println(sql);
		num=DBO.updata(sql);
		System.out.println(num);
		if(num<=0) {
			 String login_fail = "addPaper.jsp";
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
