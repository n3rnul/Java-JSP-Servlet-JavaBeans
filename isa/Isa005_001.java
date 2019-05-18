package jp.isa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
 
@WebServlet("/Isa005_001")
public class Isa005_001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		//値の取得
		String empNo01 = (String)request.getParameter("empno01");
		String empName_j = (String)request.getParameter("empname_j");
		String empName_e = (String)request.getParameter("empname_e");
		String deptName = (String)request.getParameter("deptname");
		String postName = (String)request.getParameter("postname");
		String pass01 = (String)request.getParameter("pass");
		String passCheck01 = (String)request.getParameter("passCheck");
		
		String deptNames = null;
		switch (deptName) {
		case "eigy":
			deptNames = "営業部";
			break;
		case "kans":
			deptNames = "監査部";
			break;
		case "soum":
			deptNames = "総務部";
			break;
		}
		String postNames = null;
		switch (postName) {
		case "jg":
			postNames = "一般";
			break;
		case "kr":
			postNames = "管理職";
			break;
		}

		//値の判定
		boolean zenKaku = isZenkaku(empName_j);
		System.out.println(isZenkaku(empName_j));
		boolean hanKaku = isHanKaku(empName_e);
		boolean hanKakupass = isHanKaku(pass01);
		boolean hanKakupassC = isHanKaku(passCheck01);		
		System.out.println(isHanKaku(pass01));
		System.out.println(isHanKaku(passCheck01));
		
		System.out.println(empNo01);
		System.out.println(empName_j);
		System.out.println(empName_e);
		System.out.println(pass01);
		System.out.println(passCheck01);
		
		
		HttpSession ssn = request.getSession();

		if (empNo01.length() != 0 && isZenkaku(empName_j) == true && empName_j.length() != 0
				&& isHanKaku(empName_e) == true && empName_e.length() != 0 
				&& pass01.equals(passCheck01) && pass01.length() != 0
				&& passCheck01.length() != 0 ) {
					System.out.println("認証４");
					ssn.setAttribute("empno01", empNo01);	        //画面出力
					ssn.setAttribute("empname_j", empName_j);	//画面出力
					ssn.setAttribute("empname_e", empName_e);   //画面出力
					ssn.setAttribute("deptnames", deptNames);	//画面出力
					ssn.setAttribute("deptname", deptName);
					ssn.setAttribute("postnames", postNames);   //画面出力
					ssn.setAttribute("postname", postName);
					ssn.setAttribute("password", pass01);	    //画面出力
					
					request.getRequestDispatcher("./isa005_002.jsp").
					forward(request, response);
				} else {
					request.setAttribute("Warning", "入力ミスがあります");
					request.getRequestDispatcher("./isa005_001.jsp").
					forward(request, response);
				}
		
	}
	//全角判定
	public static boolean isZenkaku(String str){
		 
		  //nullの場合はfalseを返す
		  if(str == null){
		    return false;
		  }
		 
		  //半角英数記号を判定
//		  Pattern p = Pattern.compile("^[^!-~｡-ﾟ]*$");
		  Pattern p = Pattern.compile("^[^!-~｡-ﾟ]+$");  //空文字をNGとしたい場合
		  Matcher m = p.matcher(str);
		 
		  return m.find();
		}
	//半角判定
	public static Boolean isHanKaku(String str) {
		
		    if ( str == null || str.length() == 0 )
		        return true;
		    int len = str.length();
		    byte[] bytes = str.getBytes();
		    if ( len != bytes.length )
		        return false;
		    return true;
		}


	
}
