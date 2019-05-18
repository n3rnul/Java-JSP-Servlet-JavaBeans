<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	HttpSession ssn = request.getSession();
	String workday01 = (String) ssn.getAttribute("workday01");
	String workstyle01 = (String) ssn.getAttribute("workstyle01");
	String worktime = (String) ssn.getAttribute("worktime");
	String rest01 = (String) ssn.getAttribute("rest01");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム 勤務記録登録</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録登録確認</h2>
	<p>以下の内容でよろしいですか</p>
	<form action="./Isa002_002" method="post">
		<table class="table table-hover mx-auto" style="width: 500px "border=0">
			<tr>
				<td align=left>勤務日</td>
				<td align=left>： <%=workday01%></td>
			</tr>
			<tr>
				<td align=left>勤務形態</td>
				<td align=left>： <%=workstyle01%></td>
			</tr>
			<tr>
				<td align=left>勤務時間</td>
				<td align=left>： <%=worktime%></td>
			</tr>
			<tr>
				<td align=left>休憩時間</td>
				<td align=left>： <%=rest01%></td>
			</tr>
		</table>
		<p style="height: 50px;"></p>
		<input class="btn-sm btn-primary w-100px mb-1" type="submit" value="確定">
	</form>
	<form action="./isa002_001.jsp">
		<input class="btn-sm btn-primary w-100px mt-2" data-toggle="tooltip" title="勤務記録 登録画面へ" type="submit" value="戻る">
	</form>
</body>
</html>