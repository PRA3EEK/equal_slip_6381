package beanClasses;

public class Department {

	private int did;
	private String location;
	private String name;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department(int did, String location, String name) {
		super();
		this.did = did;
		this.location = location;
		this.name = name;
	}
//	public Department() {
//		// TODO Auto-generated constructor stub
//	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", location=" + location + ", name=" + name + "]";
	}
	
	
}
