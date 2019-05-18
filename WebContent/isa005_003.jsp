<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム 従業員情報登録</title>
<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2>従業員情報登録完了</h2>
	<p>以下の従業員情報を登録しました</p>
	<form action="./isa005_001.jsp" method="post">
		<table border=0 align=center>
			<tr>
				<td align=left>従業員番号</td>
				<td align=left>:${empno01}</td>
			</tr>
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
				<td align=left>:${deptnames}</td>
			</tr>
			<tr>
				<td align=left>役職</td>
				<td align=left>:${postnames}</td>
			</tr>
			<tr>
				<td align=left>パスワード</td>
				<td align=left>:${password}</td>
			</tr>
		</table>
		<input type="submit" value="続けて登録">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input type="submit" value="メインメニューへ戻る">
	</form>
	<p class="errorMessage">${Warning}</p>
</body>
</html>