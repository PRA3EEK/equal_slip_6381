package exceptions;

public class EmployeeException extends Exception{

	String message;

	public EmployeeException(String message) {
		super();
		this.message = message;
	}
	
	public EmployeeException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
