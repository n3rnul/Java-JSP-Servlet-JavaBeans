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
	<h2>従業員情報変更</h2>
	<table border=0 align=center>
		<tr>
			<td align=left>従業員番号</td>
			<td align=left>:${empno}</td>
		</tr>
	</table>
	<p>以下の従業員情報を変更してください</p>
	<p class="errorMessage">${Warning}</p>
	<form action="./isa006_003.jsp" method="post">
		<table border=0 align=center>
			<tr>
				<td align=left>従業員名（全角文字）</td>
				<td align=left><input type="text" name="empname_j">（必須）</td>
			</tr>
			<tr>
				<td align=left>従業員名（半角ローマ字）</td>
				<td align=left><input type="text" name="empname_e">（必須）</td>
			</tr>
			<tr>
				<td align=left>所属</td>
				<td align=left><select name="deptname">
						<option value="eigy">営業部</option>
						<option value="kans">監査部</option>
						<option value="soum">総務部</option>
				</select>（必須）</td>
			</tr>
			<tr>
				<td align=left>役職</td>
				<td align=left><select name="postname">
						<option value="jg">従業員</option>
						<option value="kr">管理職</option>
				</select>（必須）</td>
			</tr>
		</table>
		<input type="submit" value="確認">
	</form>
	<form action="./isa006_001.jsp" method="post">
		<input type="submit" value="戻る">
	</form>
</body>
</html>