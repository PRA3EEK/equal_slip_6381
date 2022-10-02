package beanClasses;

import java.sql.Date;

public class LeaveRequest {
  
	private int empl_id;
	private int leave_days_request;
	private String leave_status;
	private Date leave_startDate;
	private Date leave_endDate;
	public int getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(int empl_id) {
		this.empl_id = empl_id;
	}
	public int getLeave_days_request() {
		return leave_days_request;
	}
	public void setLeave_days_request(int leave_days_request) {
		this.leave_days_request = leave_days_request;
	}
	public String getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}

	

	
	@Override
	public String toString() {
		return "LeaveRequest [empl_id=" + empl_id + ", leave_days_request=" + leave_days_request + ", leave_status="
				+ leave_status + ", leave_startDate=" + leave_startDate + ", leave_endDate=" + leave_endDate + "]";
	}
	public LeaveRequest(int empl_id, int leave_days_request, String leave_status, Date leave_startDate,
			Date leave_endDate) {
		super();
		this.empl_id = empl_id;
		this.leave_days_request = leave_days_request;
		this.leave_status = leave_status;
		this.leave_startDate = leave_startDate;
		this.leave_endDate = leave_endDate;
	}
	public Date getLeave_startDate() {
		return leave_startDate;
	}
	public void setLeave_startDate(Date leave_startDate) {
		this.leave_startDate = leave_startDate;
	}
	public Date getLeave_endDate() {
		return leave_endDate;
	}
	public void setLeave_endDate(Date leave_endDate) {
		this.leave_endDate = leave_endDate;
	}
	public LeaveRequest() {
		// TODO Auto-generated constructor stub
	}
}
