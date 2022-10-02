package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;
import exceptions.EmployeeException;

public class UseCaseChangeAddress {

	
	public static void excFun() {
		
	    EmployeeImpl ei = new EmployeeImpl();
	    
	    Scanner sc = new Scanner(System.in);
	    
		
		try {
			System.out.println("Enter employee Id");
		    int eid = sc.nextInt();
		    sc.nextLine();
			System.out.println("Enter new address");
			String add = sc.nextLine();
			System.out.println(ei.changeAddress(eid, add));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
		
				System.out.println(e.getMessage());
			
//			e.printStackTrace();
		}
		
	}
	
}
