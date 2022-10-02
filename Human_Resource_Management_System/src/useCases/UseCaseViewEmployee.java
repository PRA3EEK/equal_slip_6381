package useCases;

import java.util.List;

import beanClasses.EmployeeBeanClass;
import dao.AdminImpl;
import exceptions.EmployeeException;

public class UseCaseViewEmployee {

	public static void excFun () {
		
		AdminImpl ai = new AdminImpl();
		
		try {
			List<EmployeeBeanClass> reslist = ai.ViewEmployees();
			for(EmployeeBeanClass ebc:reslist) {
				System.out.println(ebc);
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
