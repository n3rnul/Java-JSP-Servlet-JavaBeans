package jp.isa;

public class Department {

	private String deptcode;
	private String deptname;
	
	public Department(String deptcode, String deptname) {
		super();
		
		this.deptcode = deptcode;
		this.deptname = deptname;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
}
