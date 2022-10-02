package mainHRMSApp;

import java.util.Scanner;

import useCases.UseCaseAddEmployee;
import useCases.UseCaseAddInDepartment;
import useCases.UseCaseAdminLogIn;
import useCases.UseCaseApproveLeaveRequest;
import useCases.UseCaseChangeAddress;
import useCases.UseCaseChangeDepartment;
import useCases.UseCaseChangePassword;
import useCases.UseCaseChangeUsername;
import useCases.UseCaseDeleteDepartment;
import useCases.UseCaseDeleteDepartmentByName;
import useCases.UseCaseDeleteEmployee;
import useCases.UseCaseEmployeeLogIn;
import useCases.UseCaseRequestForLeave;
import useCases.UseCaseViewDepartment;
import useCases.UseCaseViewEmployee;
import useCases.UseCaseViewLeaveRequests;
import useCases.UseCaseViewLeaveStatus;
import useCases.UseChangeMobile;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			boolean mainFlag = true;
			while(mainFlag) {
			System.out.println("Welcome to Human Resource Management System!");
	        System.out.println("1. Login as Admin");
	        System.out.println("2. Login as Employee");
	        
	        int opt = sc.nextInt();
	        
	        if(opt == 1) {
	        	boolean res = UseCaseAdminLogIn.exFun();
	        	if(res) {
	        	  boolean flag = true;
	        	  while(flag) {
	        		  System.out.println("1. Add a new Employee");
	        		  System.out.println("2. Add a new Department");
	                  System.out.println("3. Delete a Department by its Id");
	                  System.out.println("4. Delete a Department by its name");
	                  System.out.println("5. Process leave requests of employees");
	                  System.out.println("6. Change department of an employee");
	                  System.out.println("7. View Departments");
	                  System.out.println("8. View Leave Requests");
	                  System.out.println("9. Delete Employee");
	                  System.out.println("10. View Employee");
	                  System.out.println("11. exit");
	                  int optforadmin = sc.nextInt();
	                  
	                  if(optforadmin == 1) {
	                	  UseCaseAddEmployee.excFun();
	                  }else if(optforadmin == 2) {
	                	  UseCaseAddInDepartment.excFun();
	                  }else if(optforadmin == 3) {
	                	  UseCaseDeleteDepartment.excFun();
	                  }else if(optforadmin == 4) {
	                	  UseCaseDeleteDepartmentByName.excFun();
	                  }else if(optforadmin == 5) {
	                	  UseCaseApproveLeaveRequest.excFun();
	                  }else if(optforadmin == 6) {
	                	  UseCaseChangeDepartment.excFun();
	                  }else if(optforadmin == 7) {
	                	 UseCaseViewDepartment.excFun();
	                  }else if(optforadmin == 8) {
	                	  UseCaseViewLeaveRequests.excFun();
	                  }else if(optforadmin == 9){
	                	  UseCaseDeleteEmployee.excFun();
	                  }else if(optforadmin == 10){ 
	                	  UseCaseViewEmployee.excFun();
	                  }
	                  else {
	                	  flag = false;
	                  }
	        	  }
	        	}
	        }else {
	        	if(UseCaseEmployeeLogIn.excFun()) {
	        	 boolean flag2 = true;
	        		while(flag2) {
	        			
	        			System.out.println("1. Change Address");
	        			System.out.println("2. Change Mobile");
	        			System.out.println("3. Change Password");
	        			System.out.println("4. Change Username");
	        			System.out.println("5. Request for leave");
	        			System.out.println("6. View leave status");
	        			System.out.println("7. Exit");
	        			
	        			int optforemp = sc.nextInt();
	        			
	        			if(optforemp == 1) {
	        				UseCaseChangeAddress.excFun();
	        			}else if(optforemp == 2){
	        				UseChangeMobile.excFun();
	        			}else if(optforemp == 3) {
	        				UseCaseChangePassword.excFun();
	        			}else if(optforemp == 4) {
	        				UseCaseChangeUsername.excFun();
	        			}else if(optforemp == 5) {
	        				UseCaseRequestForLeave.excFun();
	        			}
	        			else if(optforemp == 6){
	        				UseCaseViewLeaveStatus.excFun();
	        			}else  {
	        				flag2 = false;
	        			}
	        			
	        		}
	        		
	        		
	        	}
	        }
	        
	        System.out.println("Try Again(Y/N)");
	        
	        String res = sc.next();
	        if(res.toLowerCase().equals("y")) {
	        	mainFlag = true;
	        }else {
	        	mainFlag = false;
	        }
	        
			}
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
}
