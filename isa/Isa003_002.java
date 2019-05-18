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

@WebServlet("/Isa003_002")
public class Isa003_002 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("workchange") != null) {

			String workchange = request.getParameter("workchange");
			System.out.println("変更ボタンの結果：" + workchange);

			String changeYear = workchange.substring(0, 4);
			String changeMonth = workchange.substring(5, 7);
			String changeDay = workchange.substring(8, 10); // 本来の勤務日

			// 遷移先の文言表示
			request.setAttribute("year", changeYear);
			request.setAttribute("month", changeMonth);
			request.setAttribute("day", changeDay);
			// フォワード
			request.getRequestDispatcher("./isa003_002.jsp").forward(request, response);
		} else {

			String workdelete = request.getParameter("workdelete");
			System.out.println("削除ボタンの結果：" + workdelete);

			String deleteYear = workdelete.substring(0, 4);
			String deleteMonth = workdelete.substring(5, 7);
			String deleteDay = workdelete.substring(8, 10); // 本来の勤務日

			// 遷移先の文言表示
			request.setAttribute("year", deleteYear);
			request.setAttribute("month", deleteMonth);
			request.setAttribute("day", deleteDay);
			// フォワード
			request.getRequestDispatcher("./isa003_005.jsp").forward(request, response);
		}
	}
}