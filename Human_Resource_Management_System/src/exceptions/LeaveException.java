package exceptions;

public class LeaveException extends Exception{

	 String message;

	public LeaveException(String message) {
		super();
		this.message = message;
	}
	 
	 public LeaveException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
