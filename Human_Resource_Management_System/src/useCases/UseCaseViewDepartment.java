package useCases;

import java.util.List;

import beanClasses.Department;
import dao.AdminImpl;
import exceptions.DepartmentException;

public class UseCaseViewDepartment {

	public static void excFun() {
		
		AdminImpl ai = new AdminImpl();
		
		try {
			List<Department> list = ai.viewDepartment();
			
			System.out.println("The size of the department list is "+list.size());
			for(Department d:list) {
				System.out.println(d);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		
	}
	
}
