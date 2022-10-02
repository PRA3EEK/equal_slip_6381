package dao;

import java.util.List;

import beanClasses.Department;
import beanClasses.EmployeeBeanClass;
import beanClasses.LeaveRequest;
import exceptions.DepartmentException;
import exceptions.EmployeeException;
import exceptions.LeaveException;

public interface Admin {
	
	//add new department
	//view department
	//update department
	//add new employees to the employee table
	//changing departments of employees
	//processing leave requests
	
	public String addIntoDepartment(int id, String location, String name) throws DepartmentException;
	
	public List<Department> viewDepartment() throws DepartmentException;
	
	public String deleteFromDepartmentById(int id) throws DepartmentException;
	
	public String deleteFromDepartmentByName (String name) throws DepartmentException;

 	public String addEmployee(String empl_name, int empl_salary, String empl_address, String mobile, int empl_leave_days, String empl_pass, int empl_department, String empl_email, String empl_username) throws EmployeeException;
 	
 	public String changeDepartment(int empl_id, int did) throws DepartmentException;
 	
 	public String approveLeaveRequests() ;
 	
 	public List<LeaveRequest> viewLeaveRequest () throws LeaveException;
 	
 	public String DeleteEmployee(int empl_id) throws EmployeeException;
 	
 	public List<EmployeeBeanClass> ViewEmployees () throws EmployeeException;
 	
// 	public String addNewDepartment (int id, String location, String name);
 	
}
