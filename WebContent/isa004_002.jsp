<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム 勤務記録一覧</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 style="height: 70px;">勤務記録詳細</h2>
	<form action="./Isa001_001" method="post">
		<select name="year">
			<option value="2019">2019</option>
			<option value="2018">2018</option>
		</select>年 <select name="month">
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select> 月 
		<input 	class="btn-sm btn-secondary w-100px ml-3" 
				type="submit" 
				value="検索">
	</form>
	<p style="height: 50px;"></p>
	<p>${year}年${month}月従業員名: ${user}</p>
	<table class="table table-hover mx-auto" style="width: 700px "border=0">
		<tr>
			<th>日</th>
			<th>曜日</th>
			<th>勤務形態</th>
			<th>勤務時間</th>
			<th>休憩時間</th>
		</tr>
	</table>
	<form action="./isa004_001.jsp" method="post">
		<input 	class="btn-sm btn-primary shadow w-150px mt-50" 
				data-toggle="tooltip" 	
				title="従業員別 勤務記録一覧へ" 
				type="submit" 
				value="戻る">
	</form>
	<form action="./isa001_002.jsp" method="post">
		<input 	class="btn-sm btn-primary shadow w-150px mt-2"
				type="submit" 
				value="メインメニューに戻る">
	</form>
	<p class="errorMessage">${message}</p>
</body>
</html>