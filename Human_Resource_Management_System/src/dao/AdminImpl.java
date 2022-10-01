package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beanClasses.Department;
import beanClasses.LeaveRequest;
import connetion.CreateConnetion;
import exceptions.DepartmentException;
import exceptions.EmployeeException;
import exceptions.LeaveException;

public class AdminImpl implements Admin{

	@Override
	
	//Inserting department into the department table with all values.
	public String addIntoDepartment(int id, String location, String name) throws DepartmentException{
		// TODO Auto-generated method stub
		try (Connection con = CreateConnetion.create()){
			PreparedStatement ps = con.prepareStatement("insert into department values (?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, location);
			ps.setString(3, name);
			
			int res = ps.executeUpdate();
		    
	  		if(res > 0) {
	  			return "Added department succesfully";
	  		}
	  		else {
	  		   throw new DepartmentException("Department is not added");
	  		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		   throw new DepartmentException(e.getMessage());
		}
		
	}

	@Override
	public List<Department> viewDepartment() throws DepartmentException {
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("select * from department");
			
			ResultSet rs  = ps.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("did");
				String location  = rs.getString("location");
				String name = rs.getString("dname");
				
				Department d = new Department(id, location, name);
				list.add(d);
			}
			
			if(list.size()>0) {
				
				return list;
			}else {
				throw new DepartmentException("No department present in Department list");
			}
			
		}catch(SQLException e) {
		   throw new DepartmentException(e.getMessage());
		}
//		return null;
	}

	
	
	@Override
	public String deleteFromDepartmentById(int id) throws DepartmentException {
		// TODO Auto-generated method stub
		
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("delete from department where did = ?");
			
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Deleted department successfully";
			}else {
				throw new DepartmentException("No department exist of the id "+id);
			}
		}
		catch(SQLException e){
			throw new DepartmentException(e.getMessage());
		}
		
//		return "";
	}

	
	
	@Override
	public String deleteFromDepartmentByName(String name) throws DepartmentException{
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
			PreparedStatement ps = con.prepareStatement("delete from department where dname = ?");
			ps.setString(1,name);
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Successfully delete department "+name;
			}else {
				throw new DepartmentException("No existing department for name "+name);
			}
		}catch(SQLException e) {
		 throw new DepartmentException(e.getMessage());
		}
	}

	
	
	@Override
	public String addEmployee(String empl_name, int empl_salary, String empl_address, String mobile,
			int empl_leave_days, String empl_pass, int empl_department, String empl_email, String empl_username)  throws EmployeeException{
		// TODO Auto-generated method stub
		String msg;
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("insert into employee (empl_name, empl_salary, empl_address, empl_mobile, empl_leave_days, empl_pass, empl_department, empl_email, empl_username) values (?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, empl_name);
			ps.setInt(2, empl_salary);
			ps.setString(3, empl_address);
			ps.setString(4, mobile);
			ps.setInt(5, empl_leave_days);
			ps.setString(6, empl_pass);
			ps.setInt(7, empl_department);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				msg = "Employee added successfully...";
			}else {
			 throw new EmployeeException("Employee is not added please try again...");
			}
			
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return msg;
	}

	@Override
	public String changeDepartment(int empl_id, int did) throws DepartmentException {
		// TODO Auto-generated method stub
		
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_department = ? where empl_id = ?");
			
		  int res = ps.executeUpdate();
			
		  if(res > 0) {
			  return "Department changed successfully";
		  }else {
			  throw new DepartmentException("No department has changed please try again");
		  }
		  
		}catch(SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
//		return null;
	}

	@Override
	public String approveLeaveRequests() {
		// TODO Auto-generated method stub
	   try(Connection con = CreateConnetion.create()) {
		   
		   int pc = 0;
		   int ac= 0;
		   
		   
		 PreparedStatement ps = con.prepareStatement(" update leave_request lr join employee e  on lr.empl_id = e.empl_id and lr.leave_days_request <= e.empl_leave_days and lr.leave_status = 'pending' set lr.leave_status = 'approved', e.empl_leave_days = e.empl_leave_days - lr.leave_days_request;");
		   
  		 int res = ps.executeUpdate();
	     
  		 PreparedStatement ps3 = con.prepareStatement("select count(*) count from leave_request group by leave_status having leave_status = 'pending'");
  		 
  		ResultSet rs = ps3.executeQuery();
  		  if(rs.next()) {
  			  pc = rs.getInt("count");
  		  }
  		  
  		  PreparedStatement ps4 = con.prepareStatement("select count(*) count from leave_request group by leave_status having leave_status = 'approved'");
  		  ResultSet rs2 = ps4.executeQuery();
  		  
  		  if(rs2.next()) {
  			  ac = rs2.getInt("count");
  				
  		  }
  		 
  		 PreparedStatement ps2 = con.prepareStatement("delete from leave_request");
  		 
  		 ps2.executeUpdate();
  		 
  		
  			 return ac + " Leave requests has been approved and "+pc+" has been rejected...";

  		
  		 
	   }
	   catch(SQLException e) {
		   
		   return e.getMessage();
	   }
	}

	@Override
	public List<LeaveRequest> viewLeaveRequest() throws LeaveException{
		// TODO Auto-generated method stub
	   try(Connection con = CreateConnetion.create()) {
		   
		    PreparedStatement ps  = con.prepareStatement("select * from leave_request");
		    
		    ResultSet rs = ps.executeQuery();
	    
		    List<LeaveRequest> list = new ArrayList<>();
		    
		    while(rs.next()) {
		    	
		    	int id = rs.getInt("empl_id");
		    	int ldr = rs.getInt("leave_days_request");
		    	String status = rs.getString("leave_status");
		    	
		    	LeaveRequest lr = new LeaveRequest(id, ldr, status);
		    	list.add(lr);
		    }
		    if(list.size()>0) {
		    	return list;
		    }
		    	throw new LeaveException("No Leave request present...");
		    
	   }catch(SQLException e) {
		   throw new LeaveException(e.getMessage());
	   }
//	   return null;
	}



}
