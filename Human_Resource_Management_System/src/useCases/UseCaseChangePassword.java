package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;
import exceptions.EmployeeException;

public class UseCaseChangePassword {

	public static void excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.out.println("Enter employee ID");
			int eid = sc.nextInt();
			
			System.out.println("Enter new Password of maximum 16 characters");
			String pass = sc.next();
			
			EmployeeImpl ei = new EmployeeImpl();
			System.out.println(ei.changePassword(eid, pass));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		
				System.out.println(e.getMessage());
			
		}
		
	}
	
}
