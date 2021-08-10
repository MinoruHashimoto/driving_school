package model;


public class Employee {
	private String employee_code;
	private String password;

	public Employee(String employee_code, String password) {
		this.employee_code=employee_code;
		this.password=password;
	}

	public String getEmployee_code() {
		return employee_code;
	}
	
	public String getPassword() {
		return password;
	}
	
}
