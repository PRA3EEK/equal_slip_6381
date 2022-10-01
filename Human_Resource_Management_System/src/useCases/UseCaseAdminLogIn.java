package useCases;

import java.util.Scanner;

import beanClasses.AdminBeanClass;
//import dao.LogIn;
import dao.LogInImpl;
import exceptions.AdminException;

public class UseCaseAdminLogIn {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin username");
		
		String unam = sc.next();
		
		System.out.println("Enter password");
		
		String pass = sc.next();
		
		LogInImpl li = new LogInImpl();
		
	 try {
		AdminBeanClass abc = li.loginAsAdmin(unam, pass);
	   System.out.println("Admin Login Successfull...");
		
	} catch (AdminException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
		
		
		
		
	}
	
}
