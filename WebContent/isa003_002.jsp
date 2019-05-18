<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>勤怠管理システム 勤務記録変更</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">勤務記録変更</h2>
	<form action="./Isa003_003" method="post">
		<table class="table table-hover mx-auto" style="width: 400px "border=0">
			<tr>
				<td>勤務日：</td>
				<td align=left>${year}年${month}月${day}日</td>
			</tr>
			<tr>
				<td></td>
				<td align=left>勤務記録を変更してください
					<p class="errorMessage">${Warning}</p>
				</td>
			</tr>
			<tr>
				<td>勤務形態</td>
				<td align=left><select name="style">
						<option value="0">通常</option>
						<option value="1">出張</option>
						<option value="2">年次休暇</option>
						<option value="3">欠勤</option>
				</select></td>
			</tr>
			<tr>
				<td>勤務時間</td>
				<td><select name="hour01">
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
		<input type="hidden" name="year" value="${year}"> <input
			type="hidden" name="month" value="${month}"> <input
			type="hidden" name="day" value="${day}"> 
			<p style="height: 50px;"></p>
			<input class="btn-sm btn-primary w-100px mb-1" type="submit" value="確認">
	</form>
	
	<form action="./isa003_001.jsp" method="post">
		<input class="btn-sm btn-primary w-100px mt-2" data-toggle="tooltip" title="勤務記録変更 トップ画面" type="submit" value="戻る">
	</form>
</body>
</html>