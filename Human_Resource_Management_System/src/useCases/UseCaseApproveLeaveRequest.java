package useCases;

import dao.AdminImpl;

public class UseCaseApproveLeaveRequest {

	
	public static void excFun() {
		
		AdminImpl ai = new AdminImpl();
		
		String res = ai.approveLeaveRequests();
		
		System.out.println(res);
		
		
	}
	
}
