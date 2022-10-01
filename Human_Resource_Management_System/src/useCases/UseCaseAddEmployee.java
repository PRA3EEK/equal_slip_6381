package useCases;

import java.util.Scanner;

import dao.AdminImpl;
import dao.LogInImpl;
import exceptions.EmployeeException;

public class UseCaseAddEmployee {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
	   String s;
	try {
		System.out.println("Enter employee name");
		String name = sc.nextLine();
		
		System.out.println("Enter salary");
		int sal = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter address");
		String add = sc.nextLine();
		
		System.out.println("Enter mobile");
		String num = sc.next();
		
		System.out.println("Enter leave days");
		int leave = sc.nextInt();
		
		System.out.println("Enter pass");
		String pass = sc.next();
		
		System.out.println("Enter department id");
		int dept = sc.nextInt();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter username");
		String uname = sc.next();
		
		AdminImpl ai = new AdminImpl();
		
		s = ai.addEmployee(name, sal, add, num, leave, pass, dept, email, uname);
		System.out.println(s);
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
//		if(e.getMessage()==null) {
//			System.out.println("There is something wrong with your input please try again with appropriate input...");
//		}else {
		System.out.println(e.getMessage());
//		}
		}
	
		
	}
	
	 
}
