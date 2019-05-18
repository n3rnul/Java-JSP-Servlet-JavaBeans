package jp.isa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Isa005_004")
public class Isa005_004 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession ssn = request.getSession();

		ssn.setAttribute("empno01", null);	        //画面出力
		ssn.setAttribute("empname_j", null);	//画面出力
		ssn.setAttribute("empname_e", null);   //画面出力
		ssn.setAttribute("deptnames", null);	//画面出力
		ssn.setAttribute("deptname", null);
		ssn.setAttribute("postnames", null);   //画面出力
		ssn.setAttribute("postname", null);
		ssn.setAttribute("password", null);	    //画面出力

		request.getRequestDispatcher("./isa001_002.jsp").
		forward(request, response);

		
	}

}
