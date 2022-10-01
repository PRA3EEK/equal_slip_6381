package useCases;

import java.util.List;

import beanClasses.LeaveRequest;
import dao.AdminImpl;
import exceptions.LeaveException;

public class UseCaseViewLeaveRequests {

	
	public static void main(String[] args) {
		
		AdminImpl ai = new AdminImpl();
		
		try {
			List<LeaveRequest> list = ai.viewLeaveRequest();
			System.out.println("Size of the LeaveRequestList is " + list.size());
			for(LeaveRequest lr:list) {
				System.out.println(lr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
				System.out.println(e.getMessage());
		}
		
	}
	
	
}
