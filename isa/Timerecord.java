package jp.isa;

public class Timerecord {

	private String workday;
	private String empno;
	private String starttime;
	private String endtime;
	private String workinghours;
	private String resthours;
	private String state;
	
	public Timerecord(String workday, String empno, String starttime, String endtime, String workinghours, String resthours,
			String state) {
		super();
		this.workday = workday;
		this.empno = empno;
		this.starttime = starttime;
		this.endtime = endtime;
		this.workinghours = workinghours;
		this.resthours = resthours;
		this.state = state;
	}

	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getWorkinghours() {
		return workinghours;
	}

	public void setWorkinghours(String workinghours) {
		this.workinghours = workinghours;
	}

	public String getResthours() {
		return resthours;
	}

	public void setResthours(String resthours) {
		this.resthours = resthours;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
