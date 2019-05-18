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
	<h2 style="height: 70px;">勤務記録削除完了</h2>
	<p>以下の勤務日を削除しました</p>
	<form action="./isa003_001.jsp" method="post">
		<table class="table table-hover mx-auto" style="width: 400px "border=0">
			<tr>
				<td align="left">勤務日</td>
				<td align="left">： ${year}年${month}月${day}日</td>
			</tr>
		</table>
		<input
		 	class="btn-sm btn-primary shadow w-150px mt-2" 
			data-toggle="tooltip" 	
			title="勤務記録 変更画面へ" 
			type="submit" 
			value="続けて変更"
			name="logout">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input
		 	class="btn-sm btn-primary shadow w-150px mt-2" 
			type="submit" 
			value="メインメニューへ戻る"
			name="logout">
	</form>
</body>