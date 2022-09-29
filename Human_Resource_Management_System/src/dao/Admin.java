package dao;

import java.util.List;

import beanClasses.Department;

public interface Admin {
	
	//add new department
	//view department
	//update department
	//add new employees to the employee table
	//changing departments of employees
	//processing leave requests
	
	public String addIntoDepartment(int id, String location, String name);
	
	public List<Department> viewDepartment();
	
	public String deleteFromDepartmentById(int id);
	
	public String deleteFromDepartmentByName (String name);

 	public String addEmployee(String empl_name, int empl_salary, String empl_address, String mobile, int empl_leave_days, String empl_pass, int empl_department);
 	
 	public String changeDepartment(int empl_id, int did);
}
