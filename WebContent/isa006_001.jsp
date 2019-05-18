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
	<h2>従業員情報一覧</h2>
	<p>所属を指定してください</p>
	<form action="./Isa006_001" method="post">
		<p>
			所属 <select name="deptname">
				<option value="eigy">営業部</option>
				<option value="kans">監査部</option>
				<option value="soum">総務部</option>
			</select> <input type="submit" value="検索">
		</p>
	</form>
	<table border=0 align=center>
		<tr>
			<th>従業員番号</th>
			<th>従業員名</th>
			<th>部署</th>
			<th>役職</th>
		</tr>
	</table>
	<form action="./isa001_002.jsp" method="post">
		<input type="submit" value="戻る">
	</form>
</body>
</html>