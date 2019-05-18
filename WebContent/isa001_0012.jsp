<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム ログイン</title>
<link rel="stylesheet" type="text/css" href="./style_login.css">
</head>
<body>
	<div id="login">
		<h2>勤怠管理システム</h2>
		<p>従業員番号とパスワードを入力してください</p>
		<form class="login" action="./Isa001_001" method="post">
			<p>
				従業員番号<input class="login" type="text" name="empno">
			</p>
			<p>
				パスワード<input class="login" type="password" name="pass">
			</p>
			<p>
				<input class="login" type="submit" value="ログイン"> <input
					class="login" type="reset" value="クリア">
			</p>
		</form>
		<p class="errorMessage">${Warning}</p>
	</div>
</body>
</html>