package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;
import exceptions.EmployeeException;

public class UseChangeMobile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.out.println("Enter employee id");
			int eid = sc.nextInt();
			
			System.out.println("Enter new mobile number");;
			String mobile = sc.next();
			
			EmployeeImpl ei = new EmployeeImpl();
			System.out.println(ei.changeMobile(eid, mobile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
				System.out.println(e.getMessage());
		
//			e.printStackTrace();
		}
		
	}
	
}
