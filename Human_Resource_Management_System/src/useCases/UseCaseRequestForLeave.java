package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;

public class UseCaseRequestForLeave {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    try {
	    	
	    	System.out.println("Enter employee Id");
	    	int eid = sc.nextInt();
	    	
	    	System.out.println("Enter leave start date (yyyy-mm-dd)");
	    	String sd = sc.next();
	    	
	    	System.out.println("Enter leave end date (yyyy-mm-dd)");
	    	String ed = sc.next();
	    	
	    	EmployeeImpl ei = new EmployeeImpl();
	    	String res = ei.requestForLeave(eid, sd, ed);
	    	System.out.println(res);
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
}
