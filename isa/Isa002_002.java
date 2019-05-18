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

@WebServlet("/Isa002_002")
public class Isa002_002 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession ssn = request.getSession();

		// SQLで実行する値
		String workday = (String)ssn.getAttribute("workday02");	
		String empno = (String)ssn.getAttribute("empNo");
		int starttime = (Integer)ssn.getAttribute("starttime");
		int endtime = (Integer)ssn.getAttribute("endtime");		
		int workinghours = (Integer)ssn.getAttribute("workinghours");
		int resthours = (Integer)ssn.getAttribute("rest02");
		int state = (Integer)ssn.getAttribute("workstyle02");

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

			//レコードの書き込み			
			ste = con.prepareStatement(
					"INSERT INTO timerecord_tbl VALUES"
					//					+ "(workday,empno,starttime,endtime,workinghours,resthours,state)"
					+ "(?,?,?,?,?,?,?)"
					//					+ "('2019-01-05','001010','500','1700','300','60','0')"
					);

			switch (state){
			// 勤務形態：通常
			case 0:
				ste.setString(1,workday);
				ste.setString(2,empno);
				if (starttime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(3, "0" + starttime);
				} else {
					ste.setInt(3, starttime);
				}
				if (endtime < 1000) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(4, "0" + endtime);
				} else {
					ste.setInt(4, endtime);
				}
				ste.setInt(5, workinghours);
				ste.setInt(6, resthours);
				ste.setInt(7, state);
				rss = ste.executeQuery();
				break;
				// 勤務形態：出張
			case 1:
				ste.setString(1,workday);
				ste.setString(2,empno);
				if (starttime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(3, "0" + starttime);
				} else {
					ste.setInt(3, starttime);
				}
				if (endtime < 1000) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(4, "0" + endtime);
				} else {
					ste.setInt(4, endtime);
				}
				ste.setInt(5, workinghours);
				ste.setInt(6, resthours);
				ste.setInt(7, state);
				rss = ste.executeQuery();
				break;
				// 勤務形態：年次休暇
			case 2:
				ste.setString(1,workday);
				ste.setString(2,empno);
				ste.setInt(3, 0000);
				ste.setInt(4, 0000);
				ste.setInt(5, 420);
				ste.setInt(6, 0000);
				ste.setInt(7, state);
				rss = ste.executeQuery();
				break;
				// 勤務形態：欠勤
			case 3:
				ste.setString(1,workday);
				ste.setString(2,empno);
				ste.setInt(3, 0000);
				ste.setInt(4, 0000);
				ste.setInt(5, 0000);
				ste.setInt(6, 0000);
				ste.setInt(7, state);
				rss = ste.executeQuery();
				break;
			}

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

			request.getRequestDispatcher("./isa002_003.jsp").forward(request, response);
		}
	}
}
