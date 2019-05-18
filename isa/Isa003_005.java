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

@WebServlet("/Isa003_005")
public class Isa003_005 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession ssn = request.getSession();

		// 勤務日の取得
		String year = (String)request.getParameter("year");
		String month = (String)request.getParameter("month");
		String day = (String)request.getParameter("day");

		// SQLで実行する値
		String workday = year + month + day;
		String empno = (String)ssn.getAttribute("empNo");

		System.out.println("SQLで実行する値:" + workday + "," + empno);

		Connection con = null;
		PreparedStatement ste = null;
		ResultSet rss = null;

		try {
			//JDBCドライバのロード
			Class.forName("org.mariadb.jdbc.Driver");
			//DB接続
			con = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/isa",
					"root", "");

			// トランザクション使用
			con.setAutoCommit(false);

			//レコードの更新			
			ste = con.prepareStatement(
					"DELETE FROM timerecord_tbl WHERE workday = ? AND empno = ?");

			ste.setString(1, workday);
			ste.setString(2, empno);
			rss = ste.executeQuery();

			// コミット（更新確定）
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//オブジェクトの破棄、解放（メモリー圧迫回避の為）
			try {
				if (rss != null)rss.close();
				if (ste != null)ste.close();
				//DB切断
				if (con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 遷移先の文言表示
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.getRequestDispatcher("./isa003_006.jsp").forward(request, response);
		}
	}
}
