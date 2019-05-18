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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>勤怠管理システム 勤務記録変更</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録変更確認</h2>
	<p>以下の内容でよろしいですか</p>

	<form action="./Isa003_004" method="post">
		<table class="table table-hover mx-auto" style="width: 400px "border=0">
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
		<input class="btn-sm btn-primary w-100px mb-1 mt-50" type="submit" value="確定">
	</form>
	<form action="./isa003_002.jsp">
		<input class="btn-sm btn-primary w-100px mt-2" data-toggle="tooltip" title="勤務記録 変更画面へ" type="submit" value="戻る">
	</form>
</body>