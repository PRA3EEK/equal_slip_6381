package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beanClasses.AdminBeanClass;
import beanClasses.EmployeeBeanClass;
import connetion.CreateConnetion;
import exceptions.AdminException;
import exceptions.EmployeeException;

public class LogInImpl implements LogIn{

	@Override
	public AdminBeanClass loginAsAdmin(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		AdminBeanClass admin = null;
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("select * from admin where admin_username = ? AND admin_password = ?");
			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			    String name = rs.getString("admin_name");
			    String uname = rs.getString("admin_username");
			    String pass = rs.getString("admin_password");
			    
			    admin = new AdminBeanClass(name, uname, pass);
			}
			else {
				throw new AdminException("No Admin with such credentials exist!");
			}
		}catch(SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return admin;
	}

	@Override
	public EmployeeBeanClass loginAsEmployee(String username, String password) throws EmployeeException{
		// TODO Auto-generated method stub
	   EmployeeBeanClass emp = null;
	   
	   try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("select * from employee where empl_username = ? and empl_pass = ?");
			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			   int id = rs.getInt("empl_id");
			   String name = rs.getString("empl_name");
			   int salary = rs.getInt("empl_salary");
			   String address = rs.getString("empl_address");
			   String mobile = rs.getString("empl_mobile");
			   int leave_days = rs.getInt("empl_leave_days");
			   String pass = rs.getString("empl_pass");
			   int dept = rs.getInt("empl_department");
			   String email = rs.getString("empl_email");
			   String uname = rs.getString("empl_username");
			   
			    
			    emp = new EmployeeBeanClass(id, name, salary, address, mobile, leave_days, pass, dept, email, uname);
			  
			    
			}
			else {
				throw new EmployeeException("No employee with such credentials exist!");
			}
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	   
	   
	}

	
	
}
