package exceptions;
import java.lang.Exception;
public class AdminException extends Exception{

	String message;

	public AdminException(String message) {
		super();
		this.message = message;
	}
	
	public AdminException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
