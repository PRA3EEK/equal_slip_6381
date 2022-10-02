package useCases;

import java.util.Scanner;

import beanClasses.LeaveRequest;
import dao.EmployeeImpl;

public class UseCaseViewLeaveStatus {

	public static void excFun () {
		
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter employee Id");
			int eid = sc.nextInt();
			
			EmployeeImpl ei = new EmployeeImpl();
           LeaveRequest lr = ei.viewLeaveRequestStatus(eid);
           
           System.out.println(lr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
