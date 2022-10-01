package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connetion.CreateConnetion;

public class EmployeeImpl implements Employee{

	@Override
	public String changeAddress(int id, String add) {
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_address = ? where empl_id = ?");
			
			ps.setString(1, add);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated address Successfully";
			}else {
				return "No such employee found";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
	
	}

	@Override
	public String changeMobile(int id, String number) {
		// TODO Auto-generated method stub
     try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_mobile = ? where empl_id = ?");
			
			ps.setString(1, number);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated mobile number Successfully";
			}else {
				return "No such employee found";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
	}

	@Override
	public String changePassword(int id, String pass) {
		// TODO Auto-generated method stub
       try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_pass = ? where empl_id = ?");
			
			ps.setString(1, pass);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated password Successfully";
			}else {
				return "No such employee found";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
	}

	@Override
	public String requestForLeave(int id, int days) {
		// TODO Auto-generated method stub
     try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("insert into leave_request values (?,?)");
			
			ps.setInt(1, id);
			ps.setInt(2, days);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Added request successfully";
			}else {
				return "No such employee found";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
	}

	@Override
	public String changeUsername(int id, String username) {
		// TODO Auto-generated method stub
try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_username = ? where empl_id = ?");
			
			ps.setString(1, username);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated username Successfully";
			}else {
				return "No such employee found";
			}
			
		}catch(SQLException e) {
			return e.getMessage();
		}
	
	}

}
