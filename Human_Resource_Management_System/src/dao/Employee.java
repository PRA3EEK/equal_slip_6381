package dao;

public interface Employee {

	public String changeAddress(int id, String add);
	
	public String changeMobile(int id, String number);
	
	public String changePassword(int id, String pass); 
	
	public String changeUsername(int id, String username);
	
	public String requestForLeave(int id, int days);
}
