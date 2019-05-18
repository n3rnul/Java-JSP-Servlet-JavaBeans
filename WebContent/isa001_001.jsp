<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム ログイン</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<h2 Class="mt-5" style="height: 70px;">勤怠管理システム</h2>

	<p>従業員番号とパスワードを入力してください</p>
	<form action="./Isa001_001" method="post">
		<p>
			<input Class="ml-3" type="text" name="empno" placeholder="従業員番号">
		</p>
		<p>
			<input Class="ml-3" type="password" name="pass" placeholder="パスワード">
		</p>

		<p style="height: 20px;"></p>

		<p>
			<input class="btn-sm btn-primary w-100px mr-2" type="submit"
				value="ログイン"> <input class="btn-sm btn-secondary w-100px"
				type="reset" value="クリア">
		</p>
	</form>
	<p class="errorMessage">${Warning}</p>
</body>
</html>