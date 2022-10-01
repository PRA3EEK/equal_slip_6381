package beanClasses;

public class LeaveRequest {
  
	private int empl_id;
	private int leave_days_request;
	private String leave_status;
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
				+ leave_status + "]";
	}
	public LeaveRequest(int empl_id, int leave_days_request, String leave_status) {
		super();
		this.empl_id = empl_id;
		this.leave_days_request = leave_days_request;
		this.leave_status = leave_status;
	}
	
	public LeaveRequest() {
		// TODO Auto-generated constructor stub
	}
}
