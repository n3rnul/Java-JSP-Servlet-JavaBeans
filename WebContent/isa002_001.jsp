<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム 勤務記録登録</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録登録</h2>
	<p>勤務記録を入力してください</p>
	<p class="errorMessage">${Warning}</p>
	<form action="./Isa002_001" method="post">
		<table class="table table-hover mx-auto" style="width: 400px "border=0">
			<tr>
				<td align=left>勤務日</td>
				<td align=left><select name="year">
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
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
				</select>月 <select name="day">
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
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select>日</td>
			</tr>
			<tr>
				<td align=left>勤務形態</td>
				<td align=left><select name="style">
						<option value="0">通常</option>
						<option value="1">出張</option>
						<option value="2">年次休暇</option>
						<option value="3">欠勤</option>
				</select></td>
			</tr>
			<tr>
				<td align=left>勤務時間</td>
				<td align=left><select name="hour01">
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
				</select>時 <select name="minutes01">
						<option value="00">00</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="40">40</option>
						<option value="50">50</option>
				</select>分 〜 <select name="hour02">
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
				</select>時 <select name="minutes02">
						<option value="00">00</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="40">40</option>
						<option value="50">50</option>
				</select>分</td>
			</tr>
		</table>
		<input class="btn-sm btn-primary w-100px mb-1 mt-5" type="submit" value="確認">
	</form>
	<form action="./isa001_002.jsp">
		<input class="btn-sm btn-primary w-100px mt-2" data-toggle="tooltip" title="メインメニュー" type="submit" value="戻る">
	</form>
</body>
</html>