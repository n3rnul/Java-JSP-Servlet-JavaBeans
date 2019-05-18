package jp.isa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// セッション取得
		HttpSession session = request.getSession(true);
		// 既存セッション破棄
		session.invalidate();
		// 新規セッションを開始
		//    		    HttpSession newSession = request.getSession(true);
		//    		    newSession.setAttribute("newlogin", true);

		//　リダイレクトでログイン画面へ遷移
		request.getRequestDispatcher("./isa001_001.jsp").forward(request, response);
	}
}
