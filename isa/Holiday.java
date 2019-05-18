package jp.isa;

import java.util.Date;

public class Holiday {

	private Date holiday;
	private String detail;
	
	public Holiday(Date holiday, String detail) {
		super();
		
		this.holiday = holiday;
		this.detail = detail;
	}

	public Date getHoliday() {
		return holiday;
	}

	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
