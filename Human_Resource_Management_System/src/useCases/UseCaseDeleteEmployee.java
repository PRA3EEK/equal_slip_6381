package useCases;

import java.util.Scanner;

import dao.AdminImpl;

public class UseCaseDeleteEmployee {

	public static void excFun () {
		Scanner sc = new Scanner(System.in);
		
		AdminImpl ai = new AdminImpl();
		try {
			System.out.println("Enter employee Id to delete");
			int eid = sc.nextInt();
			String s = ai.DeleteEmployee(eid);
			System.out.println(s);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
}
