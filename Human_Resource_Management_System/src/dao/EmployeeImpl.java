package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import beanClasses.LeaveRequest;
import connetion.CreateConnetion;
import exceptions.EmployeeException;
import exceptions.LeaveException;

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
    	    PreparedStatement ps2 = con.prepareStatement("select * from leave_request where empl_id = ?");
    	    ps2.setInt(1, id);
    	    ResultSet rs = ps2.executeQuery();
    	    PreparedStatement ps;
    	    if(rs.next()) {
    	    	ps = con.prepareStatement("update leave_request set leave_days_request = ?, leave_status = ?, leave_startDate = ?, leave_endDate=? where empl_id = ?");
                ps.setInt(1,days);
                ps.setString(2, "pending");
                ps.setDate(3, dnsd);
                ps.setDate(4, dned);
                ps.setInt(5, id);
     	    
    	    }else {
    	    	ps = con.prepareStatement("insert into leave_request values (?,?,?,?,?)");
    	    	ps.setInt(1, id);
				ps.setInt(2, days);
				ps.setString(3,"pending");
				ps.setDate(4, dnsd);
				ps.setDate(5, dned);
    	    }
    	 
			 
			
			
				
			
				
				
				
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

	@Override
	public LeaveRequest viewLeaveRequestStatus(int id) throws LeaveException {
		// TODO Auto-generated method stub
		try(Connection con = CreateConnetion.create()){
			
			PreparedStatement ps = con.prepareStatement("select * from leave_request where empl_id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int eid = rs.getInt("empl_id");
				int dayr = rs.getInt("leave_days_request");
				String stat = rs.getString("leave_status");
				Date sd = rs.getDate("leave_startDate");
				Date ed = rs.getDate("leave_endDate");
				LeaveRequest lr = new LeaveRequest(eid, dayr, stat, sd, ed);
				return lr;
			}else {
				throw new LeaveException("No present leave request with this employee id");
			}
			
		}catch(SQLException e) {
			throw new LeaveException(e.getMessage());
		}
		
		
		
	}

}
