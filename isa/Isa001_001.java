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

import jp.isa.Employee;
import jp.isa.Password;

@WebServlet("/Isa001_001")
public class Isa001_001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String empNo = request.getParameter("empno");
		String passWord = request.getParameter("pass");

		System.out.println("入力の結果：" + empNo + passWord);

		Connection con = null;
		PreparedStatement ste = null;	// 	SQLインジェクション対策
		ResultSet rss = null;	// SQLの戻り値

		// SQLの戻り値を格納する変数を初期設定
		String empno = null;
		String passwd = null;
		String empname_j = null;
		String empname_e = null;
		String deptcode = null;
		String postcode = null;
		String logicaldeleteflg = null;

		try {
			// JDBCドライバのロード
			Class.forName("org.mariadb.jdbc.Driver");

			// DB接続
			con = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/isa",
					"root", "");

			// レコードの取得
			ste = con.prepareStatement(
					"SELECT p.* ,  e.*" +
							" FROM password_tbl p INNER JOIN employee_tbl e" +
							" ON p.empno = e.empno" +
					" WHERE p.empno = ? && p.passwd = ? ");
			ste.setString(1, empNo);
			ste.setString(2, passWord);

			rss = ste.executeQuery();

			// データ保持
			ArrayList<Employee> recsEmployee = new ArrayList<Employee>();
			ArrayList<Password> recsPassword = new ArrayList<Password>();

			while (rss.next()) {

				empno = rss.getString("empno");
				passwd = rss.getString("passwd");
				empname_j = rss.getString("empname_j");
				empname_e = rss.getString("empname_e");
				deptcode = rss.getString("deptcode");
				postcode = rss.getString("postcode");
				logicaldeleteflg = rss.getString("logicaldeleteflg");

				Employee recEmployee = new Employee(empno, empname_j, empname_e, deptcode, postcode, logicaldeleteflg);
				Password recPassword = new Password(empno,passwd);	// JavaBeansでSQLの戻り値を格納
				recsEmployee.add(recEmployee);
				recsPassword.add(recPassword);

				System.out.println("SQLの結果：" + empno + passwd);
				// JavaBeansを利用してコンソール出力
				//				System.out.println("SQLの結果：" + recEmployee.getEmpno() + recEmployee.getPasswd());
			}

			//	(recsを渡す)
			// リクエスト・オブジェクトの保存
			//			request.setAttribute("retEmployee", recsEmployee);
			//			request.setAttribute("retP", recsP);

			// セッション・オブジェクトの保存
			HttpSession ssn = request.getSession();
			ssn.setAttribute("retEmployee", recsEmployee);
			ssn.setAttribute("retPassword", recsPassword);
			ssn.setAttribute("empNo" , empno);
			ssn.setAttribute("empName_j" , empname_j);

			// 入力値とSQLの戻り値が一致した場合、かつlogicaldeleteflgが”0”であれば画面遷移する。
			if  (((empNo.equals(empno)) && passWord.equals(passwd)) && logicaldeleteflg.equals("0")) {
				System.out.println("認証完了");
				//フォワード（メインメニュー）
				request.getRequestDispatcher("./isa001_002.jsp").forward(request, response);

			} // SQLの戻り値がnullの場合、画面遷移しない
			else if (empno == null || passwd == null) {
				//フォワード（ログイン画面）
				request.setAttribute("Warning", "IDまたはパスワードが一致しません");
				request.getRequestDispatcher("./isa001_001.jsp").forward(request, response);

			}  // logicaldeleteflgが”１”の場合画面遷移しない
			else if (logicaldeleteflg.equals("1")) {
				//フォワード（ログイン画面）
				request.setAttribute("Warning", "該当する従業員は存在しません");
				request.getRequestDispatcher("./isa001_001.jsp").forward(request, response);
			}

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

