package jp.isa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Isa005_002")
public class Isa005_002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession ssn = request.getSession();
		
		String empNo01 = (String)ssn.getAttribute("empNo01");
		String empName_j = (String)ssn.getAttribute("empname_j");
		String empName_e = (String)ssn.getAttribute("empname_e");
		String deptName = (String)ssn.getAttribute("deptname");
		String postName = (String)ssn.getAttribute("postname");
		String password = (String)ssn.getAttribute("password");
		String logicaldeleteflg = "0";

		Connection con = null;
		PreparedStatement ste01 = null;
		PreparedStatement ste02 = null;
		ResultSet rss01 = null;
		ResultSet rss02 = null;

		try {
			//JDBCドライバのロード
			Class.forName("org.mariadb.jdbc.Driver");
			//DB接続
			con = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/isa",
					"root", "");

			//レコードの書き込み			
			ste01 = con.prepareStatement(
					"INSERT INTO employee_tbl VALUES"
//					+ "(empno,empName_j,empName_e,deptName,postName,password)"
					+ "(?,?,?,?,?,?,?)"
//					+ "('2019-01-05','001010','500','1700','300','60','0')"
					);
//			ste02 = con.prepareStatement(
//					"INSERT INTO password_tbl VALUES"
//					+"(?,?)"
//					);
			System.out.println("ok");
			ste01.setString(1,empNo01);
			ste01.setString(2,empName_j);
			ste01.setString(3,empName_e);
			ste01.setString(4,deptName);
			ste01.setString(5,postName);
			ste01.setString(6,logicaldeleteflg);
//			ste02.setString(1,empNo01);
//			ste02.setString(2,password);
			rss01 = ste01.executeQuery();
//			rss02 = ste02.executeQuery();
			request.getRequestDispatcher("./isa005_003.jsp").forward(request, response);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//オブジェクトの破棄、解放（メモリー圧迫回避の為）
			try {
				if (rss01 != null)rss01.close();
				if (ste01 != null)ste01.close();
				if (rss02 != null)rss02.close();
				if (ste02 != null)ste02.close();
				//DB切断
				if (con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("./isa005_003.jsp").forward(request, response);
		}

		request.getRequestDispatcher("./isa005_003.jsp").forward(request, response);

		
	}

}
