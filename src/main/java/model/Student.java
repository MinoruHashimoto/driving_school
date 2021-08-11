package model;

public class Student {

	private String student_id;
	private String student_name;
	private String student_name_phonetic;
	private String birthday;
	private String address;
	private int gender;
	private String phone_number1;
	private String phone_number2;
	private String request_course;
	private int glasses;
	private String starting_date;
	private String reception_date;
	private String reception_employee;
	private String reception_name;
	private String note;

	public Student() {
	}

	public Student(String student_name, String student_name_phonetic, String birthday,
			String address, int gender, String phone_number1, String phone_number2, String request_course, int glasses,
			String starting_date, String reception_date, String reception_employee, String reception_name, String note) {
		this.student_name = student_name;
		this.student_name_phonetic = student_name_phonetic;
		this.birthday = birthday;
		this.address = address;
		this.gender = gender;
		this.phone_number1 = phone_number1;
		this.phone_number2 = phone_number2;
		this.request_course = request_course;
		this.glasses = glasses;
		this.starting_date = starting_date;
		this.reception_date = reception_date;
		this.reception_employee = reception_employee;
		this.reception_name = reception_name;
		this.note = note;
	}

	public Student(String student_id, String student_name, String student_name_phonetic, String birthday,
			String address, int gender, String phone_number1, String phone_number2, String request_course, int glasses,
			String starting_date, String reception_date, String reception_employee, String reception_name, String note) {
		
		this(student_name, student_name_phonetic, birthday,
				address, gender, phone_number1, phone_number2, request_course, glasses,
				starting_date, reception_date, reception_employee, reception_name, note);
		
		this.student_id = student_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String getStudent_name_phonetic() {
		return student_name_phonetic;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAddress() {
		return address;
	}

	public int getGender() {
		return gender;
	}

	public String getPhone_number1() {
		return phone_number1;
	}

	public String getPhone_number2() {
		return phone_number2;
	}

	public String getRequest_course() {
		return request_course;
	}

	public int getGlasses() {
		return glasses;
	}

	public String getStarting_date() {
		return starting_date;
	}

	public String getReception_date() {
		return reception_date;
	}

	public String getReception_employee() {
		return reception_employee;
	}

	public String getReception_name() {
		return reception_name;
	}

	public String getnote() {
		return note;
	}
}
