package useCases;

import java.util.Scanner;

import dao.LogInImpl;
import exceptions.EmployeeException;

public class UseCaseEmployeeLogIn {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee username");
		
		String uname = sc.next();
		
		System.out.println("Enter Password");
		
		String pass = sc.next();
		
		LogInImpl li = new LogInImpl();
		
		try {
			li.loginAsEmployee(uname, pass);
			System.out.println("Employee logIn successfull....");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Employee credentials are wrong!");
		}
	}
	
}
