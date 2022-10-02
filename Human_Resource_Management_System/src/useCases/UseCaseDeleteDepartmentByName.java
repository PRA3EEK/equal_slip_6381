package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseDeleteDepartmentByName {

	public static boolean excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			System.out.println("Enter name of the department");
			String name = sc.next();
			
			AdminImpl ai = new AdminImpl();
			System.out.println(ai.deleteFromDepartmentByName(name));
            return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		
		
		
	}
	
}
