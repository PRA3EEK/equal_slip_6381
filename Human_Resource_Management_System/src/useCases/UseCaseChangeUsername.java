package useCases;

import java.util.Scanner;

import dao.EmployeeImpl;
import exceptions.EmployeeException;

public class UseCaseChangeUsername {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
       
		try {
			 System.out.println("Enter employee id");
				int eid = sc.nextInt();
				
				System.out.println("Enter new username");
				String uname = sc.next();
				
				EmployeeImpl si = new EmployeeImpl();
			
					System.out.println(si.changeUsername(eid, uname));
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			    System.out.println(e.getMessage());
			
		}
		
		
	}
	
}
