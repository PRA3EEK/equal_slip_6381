package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseChangeDepartment {

	public static void excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			System.out.println("Enter the employee Id to change department");
			int id = sc.nextInt();
			
			System.out.println("Enter the department id in which you want to add this employee!");
			int did = sc.nextInt();
			
			
			AdminImpl ai = new AdminImpl();
		String res = ai.changeDepartment(id, did);
			System.out.println(res);
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println(e.getMessage());
		}
		
		
	}
	
	
}
