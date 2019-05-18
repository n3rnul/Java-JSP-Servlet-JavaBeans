package jp.isa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.isa.Password;

@WebServlet("/Isa004_001")
public class Isa004_001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String yearMonth = year + "-" + month;
		String department = request.getParameter("department");

		System.out.println("入力の結果：" + yearMonth + department);

		Connection con = null;
		PreparedStatement ste = null;	// 	SQLインジェクション対策
		ResultSet rss = null;	// SQLの戻り値

		String workday = null;
		String empno = null;
		String starttime = null;;
		String endtime = null;
		String workinghours = null;
		String resthours = null;
		String state = null;

		try {
			// JDBCドライバのロード
			Class.forName("org.mariadb.jdbc.Driver");

			// DB接続
			con = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/isa",
					"root", "");

			// レコードの取得
			ste = con.prepareStatement(
					// "SELECT * FROM timerecord_tbl WHERE empno = '100010' && workday LIKE '?%'");
					"SELECT * FROM timerecord_tbl WHERE workday LIKE ? AND deptcode = ?");
			ste.setString(1, yearMonth + "%");
			ste.setString(2, department);
			rss = ste.executeQuery();

			// データ保持
			ArrayList<Timerecord> recs = new ArrayList<Timerecord>();

			while (rss.next()) {

				workday = rss.getString("workday");
				empno = rss.getString("empno");
				starttime = rss.getString("starttime");
				endtime = rss.getString("endtime");
				workinghours = rss.getString("workinghours");
				resthours = rss.getString("resthours");
				state = rss.getString("state");

				Timerecord rec = new Timerecord(workday,empno,starttime,endtime,workinghours,resthours,state);	// JavaBeansでSQLの戻り値を格納
				recs.add(rec);

				System.out.println("SQLの結果：" + empno + workday + starttime + endtime + workinghours + resthours + state);
			}
			//	(recsを渡す)
			// リクエスト・オブジェクトの保存
			request.setAttribute("ret01", recs);

			// セッション・オブジェクトの保存
			//			HttpSession ssn = request.getSession();
			//			ssn.setAttribute("ret01", recs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// オブジェクト破棄、解放
			try {
				if (rss != null) rss.close();
				if (ste != null) ste.close();
				if (con != null) con.close();	// DB切断
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

