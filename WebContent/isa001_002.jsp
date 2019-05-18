<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="jp.isa.Employee"%>
<%@page import="java.util.ArrayList"%>

<%!public String deptpost_check(String dept1, String dept2, String post1, String post2) {

		if (dept1.equals(dept2) || post1.equals(post2)) {
			System.out.println("あなたにはアクセス権限があります。(soum or kr)");
			System.out.println(dept1 + "," + dept2);
			System.out.println(post1 + "," + post2);
			return "return true;";
		} else {
			System.out.println("あなたにはアクセス権限がありません。(soum or kr)");
			System.out.println(dept1 + "," + dept2);
			System.out.println(post1 + "," + post2);
			return "return false;";
		}
	}

	public String dept_check(String dept1, String dept2) {

		if (dept1.equals(dept2)) {
			System.out.println("あなたにはアクセス権限があります。(soum)");
			System.out.println(dept1 + "," + dept2);
			return "return true;";
		} else {
			System.out.println("あなたにはアクセス権限がありません。(soum)");
			System.out.println(dept1 + "," + dept2);
			return "return false;";
		}
	}%>
<%-- <%
	//ssnセッションからの値取得
	HttpSession ssn = request.getSession();
		String empno = (String)ssn.getAttribute("empNo");
		String empname_j = (String)ssn.getAttribute("empName_j");
%> --%>
<%
	//JavaBeansからの値取得
	/* String empname_j = null; */
	String deptcode = null;
	String postcode = null;

	@SuppressWarnings("unchecked")
	ArrayList<Employee> recsEmployee = (ArrayList<Employee>) session.getAttribute("retEmployee");

	for (Employee rec : recsEmployee) {
		/* empname_j = rec.getEmpname_j(); */
		deptcode = rec.getDeptcode();
		postcode = rec.getPostcode();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠管理システム メインメニュー</title>
<link rel="stylesheet" type="text/css" href="./css/N4_bootstrap.css">
</head>
<body>
	<p class="loginUser">ログインユーザ: ${empName_j}</p>
	<h2 Class="mt-5" style="height: 70px;">メインメニュー</h2>
	<p>
		<a href="./isa002_001.jsp">勤務記録登録</a>
	</p>
	<p>
		<a href="./isa003_001.jsp">勤務記録変更</a>
	</p>
	<p>
		<a href="./isa004_001.jsp"
			onclick="<%=deptpost_check("soum", deptcode, "kr", postcode)%>">勤務記録一覧</a>
	</p>
	<p>
		<a href="./isa005_001.jsp" onclick="<%=dept_check("soum", deptcode)%>">従業員情報登録</a>
	</p>
	<p>
		<a href="./isa006_001.jsp" onclick="<%=dept_check("soum", deptcode)%>">従業員情報変更</a>
	</p>
	<p>
		<a href="./isa007_001.jsp" onclick="return false;">ログ情報一覧</a>
	</p>
	<p style="height: 20px;"></p>
	<form action="./UserLogout" method="post">
		<input class="btn-sm btn-primary w-150px" type="submit" value="ログアウト">
	</form>
</body>
</html>