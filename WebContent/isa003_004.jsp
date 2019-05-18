<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>勤怠管理システム 勤務記録削除</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録変更完了</h2>
	<p>以下の内容に変更しました</p>
	<form action="./isa003_001.jsp" method="post">
		<table class="table table-hover mx-auto" style="width: 400px "border=0">
			<tr>
				<td align="left">勤務日</td>
				<td align="left">： ${workday01}</td>
			</tr>
			<tr>
				<td align="left">勤務形態</td>
				<td align="left">： ${workstyle01}</td>
			</tr>
			<tr>
				<td align="left">勤務時間</td>
				<td align="left">： ${worktime}</td>
			</tr>
			<tr>
				<td align="left">休憩時間</td>
				<td align="left">： ${rest01}</td>
			</tr>
		</table>
		<p style="height: 50px;"></p>
		<input class="btn-sm btn-primary w-100px mb-1" type="submit" value="続けて変更" name="logout">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input class="btn-sm btn-primary w-100px mt-2" type="submit" value="メインメニューへ戻る" name="logout">
	</form>
</body>