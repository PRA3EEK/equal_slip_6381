package exceptions;

public class DepartmentException extends Exception{

	String message;

	public DepartmentException(String message) {
		super();
		this.message = message;
	}
	
	public DepartmentException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
