package jp.isa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Isa002_001")
public class Isa002_001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 勤務日の取得
		String year = (String)request.getParameter("year");
		String month = (String)request.getParameter("month");
		String day = (String)request.getParameter("day");
		String workday = year + "年" + month + "月"+ day + "日";
		String swd = year + month + day;

		// 存在しない日付はエラー文言を出力
		String monthDay = month + day;
		int monthDayInt = Integer.parseInt(monthDay);
		if ((228 < monthDayInt && monthDayInt <= 231) || (monthDayInt == 431) || 
				(monthDayInt == 631) || (monthDayInt == 931) || (monthDayInt == 1131)) {

			request.setAttribute("Warning", "日付が存在しません");				
			request.getRequestDispatcher("./isa002_001.jsp").forward(request, response);
		}

		// 勤務時間の取得
		String startHour = (String)request.getParameter("hour01");
		String startMinutes = (String)request.getParameter("minutes01");
		String endHour = (String)request.getParameter("hour02");
		String endMinutes = (String)request.getParameter("minutes02");

		// intに変換
		int starthour = Integer.parseInt(startHour);
		int startminutes = Integer.parseInt(startMinutes);
		int endhour = Integer.parseInt(endHour);
		int endminutes = Integer.parseInt(endMinutes);

		// 分に換算
		int starttime = starthour * 60 + startminutes;
		System.out.println(starttime);
		int endtime = endhour * 60 + endminutes;
		System.out.println(endtime);
		// 勤務時間の計算
		int workinghours = endtime - starttime;
		System.out.println(workinghours);

		// 遷移先の勤務時間
		String worktime = startHour + "時" + startMinutes + "分" +  "〜" + endHour + "時" + endMinutes + "分";

		// 勤務形態の取得
		int state = Integer.parseInt(request.getParameter("style"));
		System.out.println(state);
		String workstyle = null;
		switch (state){
		case 0:
			workstyle = "通常";
			break;
		case 1:
			workstyle = "出張";
			break;
		case 2:
			workstyle = "年次休暇";
			break;
		case 3:
			workstyle = "欠勤";
			break;
		}
		System.out.println(workstyle);
		int startTime = Integer.parseInt(startHour + startMinutes);
		int endTime = Integer.parseInt(endHour + endMinutes);

		HttpSession ssn = request.getSession();

		if (startTime < endTime || workstyle.equals("年次休暇") || workstyle.equals("欠勤")) {
			ssn.setAttribute("workday01", workday);	//画面出力
			ssn.setAttribute("workday02", swd);
			ssn.setAttribute("workstyle01", workstyle); //画面出力
			ssn.setAttribute("workstyle02", state);
			ssn.setAttribute("worktime", worktime); //画面出力
			ssn.setAttribute("starttime", startTime);
			ssn.setAttribute("endtime", endTime);

			// 休憩時間の設定
			// 年次休暇または欠勤の場合
			if (workstyle.equals("年次休暇") || workstyle.equals("欠勤")) {
				ssn.setAttribute("rest01", "0分");	
				ssn.setAttribute("workinghours", workinghours - workinghours);
				ssn.setAttribute("rest02", 0);
			}
			else if (startTime < 830 && endTime <= 1200) {
				ssn.setAttribute("rest01", "30分"); //画面出力
				ssn.setAttribute("workinghours", workinghours - 30);
				ssn.setAttribute("rest02", 30);

			} else if (startTime < 830 && 1200 < endTime && endTime < 1700) {
				ssn.setAttribute("rest01", "90分");
				ssn.setAttribute("workinghours", workinghours - 90);
				ssn.setAttribute("rest02", 90);

			} else if (startTime < 830 && 1700 <= endTime) {
				ssn.setAttribute("rest01", "120分");
				ssn.setAttribute("workinghours", workinghours - 120);
				ssn.setAttribute("rest02", 120);

			} else if (900 <= startTime && endTime < 1200) {
				ssn.setAttribute("rest01", "0分");	
				ssn.setAttribute("workinghours", workinghours);
				ssn.setAttribute("rest02", 0);

			} else if (900 <= startTime && 1200 < endTime && endTime < 1700) {
				ssn.setAttribute("rest01", "60分");
				ssn.setAttribute("workinghours", workinghours - 60);
				ssn.setAttribute("rest02", 60);

			} else if (900 <= startTime && 1700 < endTime) {
				ssn.setAttribute("rest01", "90分");				
				ssn.setAttribute("workinghours", workinghours - 90);
				ssn.setAttribute("rest02", 90);

			} else if (1300 <= endTime && endTime < 1730) {
				ssn.setAttribute("rest01", "0分");	
				ssn.setAttribute("workinghours", workinghours);
				ssn.setAttribute("rest02", 0);

			} else if (1300 <= endTime && 1700 < endTime) {
				ssn.setAttribute("rest01", "30分");
				ssn.setAttribute("workinghours", workinghours - 30);
				ssn.setAttribute("rest02", 30);

			} else if (1730 <= endTime) {
				ssn.setAttribute("rest01", "0分");	
				ssn.setAttribute("workinghours", workinghours);
				ssn.setAttribute("rest02", 0);
			}
			request.getRequestDispatcher("./isa002_002.jsp").forward(request,response);

		} else {
			request.setAttribute("Warning", "入力した時間が不正です");				
			request.getRequestDispatcher("./isa002_001.jsp").forward(request, response);			
		}
	}
}
