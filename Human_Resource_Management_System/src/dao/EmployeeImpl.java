package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import connetion.CreateConnetion;
import exceptions.EmployeeException;

public class EmployeeImpl implements Employee{

	@Override
	public String changeAddress(int id, String add) throws EmployeeException{
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
//			String msg = null;
			PreparedStatement ps = con.prepareStatement("update employee set empl_address = ? where empl_id = ?");
			
			ps.setString(1, add);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated address Successfully";
			}else {
				throw new EmployeeException("No such employee found");
			}
			
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
	
	}

	@Override
	public String changeMobile(int id, String number) throws EmployeeException{
		// TODO Auto-generated method stub
     try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_mobile = ? where empl_id = ?");
			
			ps.setString(1, number);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated mobile number Successfully";
			}else {
				throw new EmployeeException("No such employee found");
			}
			
		}catch(SQLException e) {
		    throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public String changePassword(int id, String pass) throws EmployeeException{
		// TODO Auto-generated method stub
       try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_pass = ? where empl_id = ?");
			
			ps.setString(1, pass);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				return "Updated password Successfully";
			}else {
				throw new EmployeeException("No such employee found");
			}
			
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public String requestForLeave(int id, String start_date, String end_date) throws EmployeeException{
		// TODO Auto-generated method stub
     try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("insert into leave_request values (?,?,?,?,?)");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate sd = LocalDate.parse(start_date, dtf);
			LocalDate ed = LocalDate.parse(end_date, dtf);
			
			if(sd.isAfter(ed)) {
				return "Starting date is after end date!";
			}else {
				long d = ChronoUnit.DAYS.between(sd, ed);
				int days = (int)d;
//				System.out.println(days);
//				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				
				
				
				Date dnsd = Date.valueOf(start_date);
				Date dned = Date.valueOf(end_date);
				
			
				
				
				ps.setInt(1, id);
				ps.setInt(2, days);
				ps.setString(3,"pending");
				ps.setDate(4, dnsd);
				ps.setDate(5, dned);
				int res = ps.executeUpdate();
				if(res > 0) {
					return "Added request successfully";
				}else {
					throw new EmployeeException("No such employee found");
				}
			}
			
			
			
		
			
			
			
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public String changeUsername(int id, String username) throws EmployeeException{
		// TODO Auto-generated method stub
try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("update employee set empl_username = ? where empl_id = ?");
			
			ps.setString(1, username);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
//			System.out.println(res);
			if(res > 0) {
				return "Updated username Successfully";
			}
//			}else {
			throw new EmployeeException("No such employee found");
//			}
			
		}catch(Exception e) {
//			System.out.println(e.getMessage());
			throw new EmployeeException(e.getMessage());
		}
	
	}

}
