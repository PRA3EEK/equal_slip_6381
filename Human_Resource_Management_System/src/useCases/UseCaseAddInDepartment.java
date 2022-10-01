package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseAddInDepartment {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department Id");
		int id = sc.nextInt();
		
		System.out.println("Enter department location");
		String loc = sc.next();
		
		System.out.println("Enter department name");
		String depName = sc.next();
		
		AdminImpl ai = new AdminImpl();
		String s;
		try {
			s = ai.addIntoDepartment(id, loc, depName);
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
		
	}
}

