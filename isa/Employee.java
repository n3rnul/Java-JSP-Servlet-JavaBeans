package jp.isa;

public class Employee {

	private String empno;
	private String empname_j;
	private String empname_e;
	private String deptcode;
	private String postcode;
	private String logicaldeleteflg;
	
	public Employee(String empno, String empname_j, String empname_e, String deptcode, String postcode,
			String logicaldeleteflg) {
		super();
		
		this.empno = empno;
		this.empname_j = empname_j;
		this.empname_e = empname_e;
		this.deptcode = deptcode;
		this.postcode = postcode;
		this.logicaldeleteflg = logicaldeleteflg;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpname_j() {
		return empname_j;
	}

	public void setEmpname_j(String empname_j) {
		this.empname_j = empname_j;
	}

	public String getEmpname_e() {
		return empname_e;
	}

	public void setEmpname_e(String empname_e) {
		this.empname_e = empname_e;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLogicaldeleteflg() {
		return logicaldeleteflg;
	}

	public void setLogicaldeleteflg(String logicaldeleteflg) {
		this.logicaldeleteflg = logicaldeleteflg;
	}
	
}
