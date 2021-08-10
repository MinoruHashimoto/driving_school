package model;


public class Student {
	private String employee_code;
	private String password;
	
	private String student_id;
	private String student_name;
	private String student_name_phonetic;
	private String birth_year;
	private String birth_manth;
	private String birth_day;
	private String address;
	private int gender = -1;
	if (request.getAttribute("gender") != null) {
		gender = (int) request.getAttribute("gender");
	}
	private String phone_number1;
	private String phone_number2;
	private String request_course;
	private int glasses = -1;
	if (request.getAttribute("glasses") != null) {
		glasses = (int) request.getAttribute("glasses");
	}
	private Date starting_date = (Date) request.getAttribute("starting_date");
	private Date reception_date = (Date) request.getAttribute("reception_date");
	private String reception_employee = (String) request.getAttribute("reception_employee");
	private String reception_name = (String) request.getAttribute("reception_name");
	private String note = (String) request.getAttribute("note");
	

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

