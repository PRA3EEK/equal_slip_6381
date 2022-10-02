package useCases;

import java.util.Scanner;

import beanClasses.AdminBeanClass;
//import dao.LogIn;
import dao.LogInImpl;
import exceptions.AdminException;

public class UseCaseAdminLogIn {

	public static boolean  exFun() {
		
		
		
	 try {
		 Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Admin username");
			
			String unam = sc.next();
			
			System.out.println("Enter password");
			
			String pass = sc.next();
			
			LogInImpl li = new LogInImpl();
		AdminBeanClass abc = li.loginAsAdmin(unam, pass);
	   System.out.println("Admin Login Successfull...");
	   System.out.println("Welcome "+abc.getName());
	   return true;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println(e.getMessage());
		return false;
	}
		
		
		
		
	}
	
}
