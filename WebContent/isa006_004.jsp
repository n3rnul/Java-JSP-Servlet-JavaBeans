<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム 従業員情報変更</title>
<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2>従業員情報変更完了</h2>
	<table border=0 align=center>
		<tr>
			<td align=left>従業員番号</td>
			<td align=left>:${empno}</td>
		</tr>
	</table>
	<p>以下の従業員情報を変更しました</p>
	<form action="./isa006_001.jsp" method="post">

		<table border=0 align=center>
			<tr>
				<td align=left>従業員名（全角文字）</td>
				<td align=left>:${empname_j}</td>
			</tr>
			<tr>
				<td align=left>従業員名（半角ローマ字）</td>
				<td align=left>:${empname_e}</td>
			</tr>
			<tr>
				<td align=left>所属</td>
				<td align=left>:${deptname}</td>
			</tr>
			<tr>
				<td align=left>役職</td>
				<td align=left>:${postname}</td>
			</tr>
		</table>
		<input type="submit" value="続けて変更">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input type="submit" value="メインメニューへ戻る">
	</form>
</body>
</html>