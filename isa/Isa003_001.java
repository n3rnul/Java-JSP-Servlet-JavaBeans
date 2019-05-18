package jp.isa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Isa003_001")
public class Isa003_001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession ssn = request.getSession();

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String yearMonth = year + "-" + month;
		String empno = (String)ssn.getAttribute("empNo");

		System.out.println("年月と従業員番号：" + yearMonth + ","+ empno);

		Connection con = null;
		PreparedStatement ste = null;	// 	SQLインジェクション対策
		ResultSet rss = null;	// SQLの戻り値

		String workday = null;
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
					"SELECT * FROM timerecord_tbl WHERE workday LIKE ? AND empno = ?");

			ste.setString(1, yearMonth + "%");
			ste.setString(2, empno);
			rss = ste.executeQuery();

			// データ保持
			ArrayList<Timerecord> recsTimerecord = new ArrayList<Timerecord>();

			while (rss.next()) {

				workday = rss.getString("workday");
				empno = rss.getString("empno");
				starttime = rss.getString("starttime");
				endtime = rss.getString("endtime");
				workinghours = rss.getString("workinghours");
				resthours = rss.getString("resthours");
				state = rss.getString("state");

				Timerecord recTimerecord = new Timerecord(workday,empno,starttime,endtime,workinghours,resthours,state);	// JavaBeansでSQLの戻り値を格納
				recsTimerecord.add(recTimerecord);

				System.out.println(
						"SQLの結果：" + empno + ","+ workday + ","+ starttime + "," + endtime + ","+ workinghours + ","+ resthours + ","+ state);
			}
			//	(recsを渡す)
			// リクエスト・オブジェクトの保存
			//			request.setAttribute("ret01", recs);

			// セッション・オブジェクトの保存
			ssn.setAttribute("retTimerecord",recsTimerecord);
			ssn.setAttribute("workday",workday);
			ssn.setAttribute("state",state);
			ssn.setAttribute("starttime",starttime);
			ssn.setAttribute("endtime",endtime);
			ssn.setAttribute("resthours",resthours);

			// 遷移先の文言表示
			String Year = workday.substring(0,4);
			String Month = workday.substring(5,7);
			request.setAttribute("YearMonthTimerecord", Year + "年" + Month + "月の勤務記録");

			// フォワード
			request.getRequestDispatcher("./isa003_001.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			// フォワード（該当データがない場合遷移しない）
			request.setAttribute("Warning", "該当する勤務記録が存在しません");
			request.getRequestDispatcher("./isa003_001.jsp").forward(request, response);
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