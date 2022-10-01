package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;
import exceptions.EmployeeException;

public class UseCaseChangePassword {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee ID");
		int eid = sc.nextInt();
		
		System.out.println("Enter new Password of maximum 16 characters");
		String pass = sc.next();
		
		EmployeeImpl ei = new EmployeeImpl();
		try {
			System.out.println(ei.changePassword(eid, pass));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		
				System.out.println(e.getMessage());
			
		}
		
	}
	
}
