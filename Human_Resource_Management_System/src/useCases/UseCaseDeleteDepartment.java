package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseDeleteDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);;
		
		
		
		
		try {
			System.out.println("Enter the department id to delete");
			int did = sc.nextInt();
			
			AdminImpl ai = new AdminImpl();
			System.out.println(ai.deleteFromDepartmentById(did));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
