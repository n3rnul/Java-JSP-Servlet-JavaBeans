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
	<h2 style="height: 70px;">勤務記録削除確認</h2>
	<p>以下の勤務日でよろしいですか</p>

	<form action="./Isa003_005" method="post">
		<table class="table table-hover mx-auto" style="width: 400px" border=0">
			<tr>
				<td align=left>勤務日</td>
				<td align=left>： <input type="hidden" name="year"
					value="${year}">${year}年 <input type="hidden" name="month"
					value="${month}">${month}月 <input type="hidden" name="day"
					value="${day}">${day}日</td>
			</tr>
		</table>
		<p style="height: 50px;"></p>
		<input class="btn-sm btn-primary w-100px mb-1 mt-50" type="submit"
			value="確定">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input class="btn-sm btn-primary shadow w-100px mt-2"
			data-toggle="tooltip" title="勤務記録 変更画面へ" type="submit" value="戻る">
	</form>
</body>