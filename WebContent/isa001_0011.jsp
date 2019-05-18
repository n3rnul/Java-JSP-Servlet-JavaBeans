<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム ログイン</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<form action="./Isa001_001" method="post" name="Login_Form"
				class="form-signin">
				<h2 class="form-signin-heading" align=center>勤怠管理システム</h2>
				<p class="form-signin-heading" align=center>従業員番号とパスワードを入力してください</p>
				<hr class="colorgraph">
				<br>
				<table align="center" border="0">
					<tr>
						<td><input type="text" class="form-control" name="empno"
							placeholder="従業員番号" required="" autofocus="" /></td>
					</tr>
					<tr>
						<td><input type="password" class="form-control" name="pass"
							placeholder="パスワード" required="" /></td>
					</tr>
					<tr>
						<td>
							<button class="btn btn-lg btn-primary btn-block" name="submit"
								value="login" type="submit">ログイン</button>
							<button class="btn btn-lg btn-primary btn-block" name="reset"
								value="clear" type="reset">クリア</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<p class="errorMessage" align="center">
		<font color="red">${Warning}</font>
	</p>
</body>
</html>