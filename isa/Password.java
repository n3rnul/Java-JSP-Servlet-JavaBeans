package jp.isa;

public class Password {

	private String empno;
	private String passwd;
	
	public Password(String empno, String passwd) {
		super();
		this.empno = empno;
		this.passwd = passwd;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
