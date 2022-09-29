package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beanClasses.Department;
import connetion.CreateConnetion;

public class AdminImpl implements Admin{

	@Override
	
	//Inserting department into the department table with all values.
	public String addIntoDepartment(int id, String location, String name) {
		// TODO Auto-generated method stub
		try (Connection con = CreateConnetion.create()){
			PreparedStatement ps = con.prepareStatement("insert into department values (?, ?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, location);
			ps.setString(3, name);
			
			int res = ps.executeUpdate();
		    
	  		if(res > 0) {
	  			return "Added department succesfully";
	  		}
	  		else {
	  			return "Department is not added";
	  		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  return e.getMessage();
		}
		
	}

	@Override
	public List<Department> viewDepartment() {
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
			
			
			return list;
			
		}catch(SQLException e) {
		   System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String deleteFromDepartmentById(int id) {
		// TODO Auto-generated method stub
		
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("delete from department where did = ?");
			
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Deleted department successfully";
			}else {
				return "No department exist of the id "+id;
			}
		}
		catch(SQLException e){
			return e.getMessage();
		}
		
//		return "";
	}

	@Override
	public String deleteFromDepartmentByName(String name) {
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
			PreparedStatement ps = con.prepareStatement("delete from department where dname = ?");
			ps.setString(1,name);
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Successfully delete department "+name;
			}else {
				return "No existing department for name "+name;
			}
		}catch(SQLException e) {
			return e.getMessage();
		}
	}

	@Override
	public String addEmployee(String empl_name, int empl_salary, String empl_address, String mobile,
			int empl_leave_days, String empl_pass, int empl_department) {
		// TODO Auto-generated method stub
		
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("insert into employee (empl_name, empl_salary, empl_address, empl_mobile, empl_leave_days, empl_pass, empl_department) values (?,?,?,?,?,?,?)");
			
			ps.setString(1, empl_name);
			ps.setInt(2, empl_salary);
			ps.setString(3, empl_address);
			ps.setString(4, mobile);
			ps.setInt(5, empl_leave_days);
			ps.setString(6, empl_pass);
			ps.setInt(7, empl_department);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Employee added successfully";
			}else {
				return "Employee is not added please try again";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
		
	}

	@Override
	public String changeDepartment(int empl_id, int did) {
		// TODO Auto-generated method stub
		
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_department = ? where empl_id = ?");
			
		  int res = ps.executeUpdate();
			
		  if(res > 0) {
			  return "Department changed successfully";
		  }else {
			  return "No department has changed please try again";
		  }
		  
		}catch(SQLException e) {
			
		}
		return null;
	}

}
