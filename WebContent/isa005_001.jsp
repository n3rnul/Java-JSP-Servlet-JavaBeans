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
	<h2>従業員情報登録</h2>
	<p>登録する従業員情報を入力してください</p>
	<p class="errorMessage">${warning}</p>
	<div>
		<form action="./Isa005_001" method="post">
			<table border=0 align=center>
				<tr>
					<td align=left>従業員番号</td>
					<td align=left><input type="text" name="empno01">（必須）</td>
				</tr>
				<tr>
					<td align=left>従業員名（全角文字）</td>
					<td align=left><input type="text" name="empname_j">（必須）</td></tr>
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
				<tr>
					<td align=left>パスワード</td>
					<td align=left><input type="password" name="pass">（必須）
					</td>
				</tr>
				<tr>
					<td align=left>パスワード（確認用）</td>
					<td align=left><input type="password" name="passCheck">（必須）
					</td>
				</tr>
			</table>
			<input type="submit" value="確認">
		</form>
		<form action="./isa001_002.jsp" method="post">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>