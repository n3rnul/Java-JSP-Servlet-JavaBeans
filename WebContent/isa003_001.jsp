<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jp.isa.Timerecord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>勤怠管理システム 勤務記録変更</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録変更</h2>
	<p>変更する勤務記録を選択してください</p>
	<form action="./Isa003_001" method="post">
		<select name="year">
			<option value="2019">2019</option>
			<option value="2018">2018</option>
		</select>年 <select name="month">
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select> 月 <input class="btn-sm btn-secondary w-50px ml-3" type="submit"
			value="検索">
	</form>

	<form action="./Isa003_002" method="post">
		<table class="table table-hover mx-auto" style="width: 700px" border=0">
			<p>${YearMonthTimerecord}</p>
			<p class="errorMessage">${Warning}</p>
		</table>
		<table class="table table-hover mx-auto" style="width: 700px" border=0">
			<tr>
				<th align=left>日</th>
				<th align=left>曜日</th>
				<th align=left>勤務形態</th>
				<th align=left>勤務時間</th>
				<th align=left>休憩時間</th>
				<th align=left></th>
				<th align=left></th>
				<th align=left></th>
				<th align=left></th>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Timerecord> recsTimerecord = (ArrayList<Timerecord>) session.getAttribute("retTimerecord");

				if (recsTimerecord != null) {
			%>
			<%
				for (Timerecord recTimerecord : recsTimerecord) {
						// // 勤務開始時間と勤務終了時間を初期設定
						String startHour = "00"; // HH
						String startMinutes = "00"; // MM
						String endHour = "00";
						String endMinutes = "00";

						// 勤務日から曜日を取得（日本語表記）
						Calendar cal = Calendar.getInstance();
						int Year = Integer.parseInt(recTimerecord.getWorkday().substring(0, 4));
						int Month = Integer.parseInt(recTimerecord.getWorkday().substring(5, 7));
						int Day01 = Integer.parseInt(recTimerecord.getWorkday().substring(8, 10)); // 本来の勤務日
						int Day02 = Day01 + 4; // なぜか曜日がズレるので調整（例：金曜日→火曜日）
						cal.set(Year, Month, Day02); // 曜日を取得する値をセット

						System.out.println(Year + "," + Month + "," + Day01);
						System.out.println(cal.get(Calendar.YEAR) + "年" + cal.get(Calendar.MONTH) + "月"
								+ cal.get(Calendar.DATE) + "日"); //
						System.out.println("曜日：" + cal.get(Calendar.DAY_OF_WEEK)); // 曜日の値だけ

						SimpleDateFormat Weeks = new SimpleDateFormat("EEE", Locale.JAPANESE); // 曜日を日本語化するインスタンスを生成
						Date currentTime = cal.getTime(); // 

						// 勤務形態の文字変換
						String state = recTimerecord.getState();
						switch (state) {
						case "0":
							state = "通常";
							break;
						case "1":
							state = "出張";
							break;
						case "2":
							state = "年次休暇";
							break;
						case "3":
							state = "欠勤";
							break;
						}
						// 勤務開始時間または勤務終了時間が0の場合
						if (recTimerecord.getStarttime().equals("0") || recTimerecord.getEndtime().equals("0")) {

							startHour = "00"; // HH
							startMinutes = "00"; // MM
							endHour = "00";
							endMinutes = "00";

						} else {
							startHour = recTimerecord.getStarttime().substring(0, 2); // HH
							startMinutes = recTimerecord.getStarttime().substring(2, 4); // MM
							endHour = recTimerecord.getEndtime().substring(0, 2);
							endMinutes = recTimerecord.getEndtime().substring(2, 4);
						}

						out.println("<tr>");
						out.println("<td align=left>" + recTimerecord.getWorkday().substring(8, 10) + "日" + "</td>"); // 日
						out.println("<td align=left>" + Weeks.format(currentTime) + "</td>"); // 曜日
						out.println("<td align=left>" + state + "</td>"); // 勤務形態
						out.println("<td align=left>" + startHour + "時" + startMinutes + "分" + " 〜 " + endHour + "時"
								+ endMinutes + "分" + "</td>"); // 勤務時間
						out.println("<td align=left>" + recTimerecord.getResthours() + "分" + "</td>"); // 休憩時間
						out.println("<td align=left>" + "</td>");
						out.println("<td align=left>" + "</td>");
						out.println("<td align=left>" + "<button type='submit' name='workchange' value='"
								+ recTimerecord.getWorkday() + "'>" + "変更" + "</td>"); // 変更
						out.println("<td align=left>" + "<button type='submit' name='workdelete' value='"
								+ recTimerecord.getWorkday() + "'>" + "削除" + "</td>"); // 削除
						out.println("</tr>");
					}
			%>
		</table>
		<%
			}
		%>
	</form>

	<form action="./isa001_002.jsp" method="post">
		<input class="btn-sm btn-primary shadow w-100px mt-2"
			data-toggle="tooltip" title="メインメニュー" type="submit" value="戻る">
	</form>
	<p style="height: 50px;"></p>
</body>
</html>