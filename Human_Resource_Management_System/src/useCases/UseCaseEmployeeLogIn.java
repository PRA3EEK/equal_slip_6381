package useCases;

import java.util.Scanner;

import dao.LogInImpl;
import exceptions.EmployeeException;

public class UseCaseEmployeeLogIn {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			System.out.println("Enter Employee username");
			
			String uname = sc.next();
			
			System.out.println("Enter Password");
			
			String pass = sc.next();
			
			LogInImpl li = new LogInImpl();
			li.loginAsEmployee(uname, pass);
			System.out.println("Employee logIn successfull....");
		} catch (Exception ee) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(ee.getMessage());
		}
	}
	
}
