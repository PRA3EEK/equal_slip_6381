package beanClasses;

public class EmployeeBeanClass {
  
	private int id;
	private String name;
	private int salary;
	private String address;
	private String mobile;
	private int leave_days;
	private String password;
	private int dept;
	private String email;
	private String username;
	public EmployeeBeanClass(int id, String name, int salary, String address, String mobile, int leave_days,
			String password, int dept, String email, String username) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.mobile = mobile;
		this.leave_days = leave_days;
		this.password = password;
		this.dept = dept;
		this.email = email;
		this.username = username;
	}
	public EmployeeBeanClass() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeBeanClass [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ ", mobile=" + mobile + ", leave_days=" + leave_days + ", password=" + password + ", dept=" + dept
				+ ", email=" + email + ", username=" + username + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getLeave_days() {
		return leave_days;
	}
	public void setLeave_days(int leave_days) {
		this.leave_days = leave_days;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
