package dao;

import exceptions.EmployeeException;

public interface Employee { 

	public String changeAddress(int id, String add) throws EmployeeException;
	
	public String changeMobile(int id, String number) throws EmployeeException;
	
	public String changePassword(int id, String pass) throws EmployeeException; 
	
	public String changeUsername(int id, String username) throws EmployeeException;
	
	public String requestForLeave(int id, String start_date, String end_date) throws EmployeeException;
}
