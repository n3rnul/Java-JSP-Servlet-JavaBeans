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

@WebServlet("/Isa003_004")
public class Isa003_004 extends HttpServlet {
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

		System.out.println(workday + "," + empno + "," + starttime + "," + endtime + "," + workinghours + "," + resthours + "," + state);

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
					"UPDATE timerecord_tbl SET starttime = ?, endtime = ?, workinghours = ?, resthours = ?, state = ? WHERE workday = ? AND empno = ?");

			switch (state){
			// 勤務形態：通常
			case 0:
				if (starttime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(1, "0" + starttime);
				} else {
					ste.setInt(1, starttime);
				}
				if (endtime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(2, "0" + endtime);
				} else {
					ste.setInt(2, endtime);
				}
				ste.setInt(3, workinghours);
				ste.setInt(4, resthours);
				ste.setInt(5, state);
				ste.setString(6, workday);
				ste.setString(7, empno);
				rss = ste.executeQuery();
				break;
				// 勤務形態：出張
			case 1:
				if (starttime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(1, "0" + starttime);
				} else {
					ste.setInt(1, starttime);
				}
				if (endtime < 960) { 	// 10時より前の場合は先頭に0パディング
					ste.setString(2, "0" + endtime);
				} else {
					ste.setInt(2, endtime);
				}
				ste.setInt(3, workinghours);
				ste.setInt(4, resthours);
				ste.setInt(5, state);
				ste.setString(6, workday);
				ste.setString(7, empno);
				rss = ste.executeQuery();
				break;
				// 勤務形態：年次休暇
			case 2:
				ste.setInt(1, 0000);
				ste.setInt(2, 0000);
				ste.setInt(3, 420);
				ste.setInt(4, 0000);
				ste.setInt(5, state);
				ste.setString(6, workday);
				ste.setString(7, empno);
				rss = ste.executeQuery();
				break;
				// 勤務形態：欠勤
			case 3:
				ste.setInt(1, 0000);
				ste.setInt(2, 0000);
				ste.setInt(3, 0000);
				ste.setInt(4, 0000);
				ste.setInt(5, state);
				ste.setString(6, workday);
				ste.setString(7, empno);
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

			request.getRequestDispatcher("./isa003_004.jsp").forward(request, response);
		}
	}
}
