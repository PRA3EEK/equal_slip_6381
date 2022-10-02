package useCases;

import java.util.Scanner;

import beanClasses.EmployeeBeanClass;
import dao.LogInImpl;
import exceptions.EmployeeException;

public class UseCaseEmployeeLogIn {

	
	public static boolean excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			System.out.println("Enter Employee username");
			
			String uname = sc.next();
			
			System.out.println("Enter Password");
			
			String pass = sc.next();
			
			LogInImpl li = new LogInImpl();
			EmployeeBeanClass ebc = li.loginAsEmployee(uname, pass);
			System.out.println("Employee logIn successfull....");
			System.out.println("Welcome "+ebc.getName());
			return true;
		} catch (Exception ee) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(ee.getMessage());
			return false;
		}
	}
	
}
