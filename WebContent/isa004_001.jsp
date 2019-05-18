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
	<h2 style="height: 70px;">従業員別勤務記録一覧</h2>
	<p>閲覧する勤務記録の年月、所属を指定してください</p>
	
	<table class="table table-hover mx-auto" style="width: 400px "border=0">
	<tr><td></td>
	<td align=left><form action="./Isa004_001" method="post">
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
	</td>
	</tr>
	
	<tr>
	<td>所属</td>
	<td align=left>
		<select name="department">
			<option value="eigy">営業部</option>
			<option value="kans">監査部</option>
			<option value="soum">総務部</option>
		</select>
		<input 	class="btn-sm btn-secondary w-100px ml-3" 
				type="submit" 
				value="検索">
	</td>
	</form>
	</tr>
	</table>
	
	<p>${year}年${month}月の従業員別勤務記録一覧</p>
	<table class="table table-hover mx-auto" style="width: 700px "border=0">
		<tr>
			<th>従業員番号</th>
			<th>従業員名</th>
			<th>勤務時間合計</th>
			<th>通常時間外合計</th>
			<th>年次休暇</th>
			<th>欠勤</th>
			<th>出張</th>
		</tr>
	</table>
	<form action="./isa001_002.jsp" method="post">
		<input
		 	class="btn-sm btn-primary shadow w-100px mt-2" 
			data-toggle="tooltip" 	
			title="メインメニュー" 
			type="submit" 
			value="戻る">
	</form>
	<p class="errorMessage">${message}</p>
</body>
</html>