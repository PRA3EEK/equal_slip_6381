package dao;

import beanClasses.AdminBeanClass;
import beanClasses.EmployeeBeanClass;
import exceptions.AdminException;
import exceptions.EmployeeException;

public interface LogIn {

    AdminBeanClass loginAsAdmin (String username, String password) throws AdminException;
    
    EmployeeBeanClass loginAsEmployee(String username, String password) throws EmployeeException;
	
	
}
