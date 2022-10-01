package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseDeleteDepartmentByName {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			System.out.println("Enter name of the department");
			String name = sc.next();
			
			AdminImpl ai = new AdminImpl();
			System.out.println(ai.deleteFromDepartmentByName(name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
