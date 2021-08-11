package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Student;

public class T_StudentDAO extends parentDAO {
	
	Date now = new Date();

    //今日の日付をyyyyMMddの形で出力する
    SimpleDateFormat format_date = new SimpleDateFormat("yyyyMMdd");
    String date = format_date.format(now);
    //現在時刻をHHmmssSSの形で出力する
    SimpleDateFormat format_time = new SimpleDateFormat("HHmmssSS");
    String time = format_time.format(now);
    
    
	
	public Student search(String student_id) {
		try {
			Connection connection = DriverManager.getConnection(LOCAL_DATABASE_URL, "postgres", "kanri");

			Student student_return = null;

			String sql = "SELECT * FROM T_STUDENT "
					+ "WHERE STUDENT_ID=? AND DELETE_FLG=0; ";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, student_id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String student_name = result.getString("STUDENT_NAME");
				String student_name_phonetic = result.getString("student_name_phonetic");
				String birthday = result.getString("birthday");
				String address = result.getString("address");
				int gender = result.getInt("gender");
				String phone_number1 = result.getString("phone_number1");
				String phone_number2 = result.getString("phone_number2");
				String request_course = result.getString("request_course");
				int glasses = result.getInt("glasses");
				String starting_date = result.getString("starting_date");
				String reception_date = result.getString("reception_date");
				String reception_employee = result.getString("reception_employee");
				String reception_name = result.getString("reception_name");
				String note = result.getString("note");

				student_return = new Student(student_id, student_name, student_name_phonetic, birthday,
						address, gender, phone_number1, phone_number2, request_course, glasses,
						starting_date, reception_date, reception_employee, reception_name, note);
			}

			if (student_return != null) {
				return student_return;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean del(String student_id ,String login_id) {
		try {
			Connection connection = DriverManager.getConnection(LOCAL_DATABASE_URL, "postgres", "kanri");
			
			String sql = "UPDATE T_STUDENT SET delete_flg=1, update_date=?,update_time=?,update_id=?, "
					+ "update_count=update_count+1 WHERE STUDENT_ID=? AND DELETE_FLG=0; ";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, date);
			statement.setString(2, time);
			statement.setString(3, login_id);
			statement.setString(4, student_id);
			
			int result = statement.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean add(Student student, String login_id) {
		
		try {
			Connection connection = DriverManager.getConnection(LOCAL_DATABASE_URL, "postgres", "kanri");
			
			String sql = "INSERT INTO T_STUDENT(student_name, student_name_phonetic, birthday,"
					+ "						address, gender, phone_number1, phone_number2, request_course, glasses,"
					+ "						starting_date, reception_date, reception_employee, reception_name, note,"
					+ "insert_date,insert_time,insert_id) WHERE STUDENT_ID=? AND DELETE_FLG=0; ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, student.getStudent_name());
			statement.setString(2, student.getStudent_name_phonetic());
			statement.setString(3, student.getBirthday());
			statement.setString(4,student.getAddress() );
			statement.setInt(5, student.getGender());
			statement.setString(6, student.getPhone_number1());
			statement.setString(7, student.getPhone_number2());
			statement.setString(8, student.getRequest_course());
			statement.setInt(9, student.getGlasses());
			statement.setString(10, student.getStarting_date());
			statement.setString(11, student.getReception_date());
			statement.setString(12, student.getReception_employee());
			statement.setString(13, student.getReception_name());
			statement.setString(14, student.getnote());
			statement.setString(15, date);
			statement.setString(16, time);
			statement.setString(17, login_id);
			statement.setString(18, student.getStudent_id());
			
			int result = statement.executeUpdate();
			
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean mod(Student student, String login_id) {
		
		try {
			Connection connection = DriverManager.getConnection(LOCAL_DATABASE_URL, "postgres", "kanri");
			
			String sql = "UPDATE T_STUDENT SET student_name=?, student_name_phonetic=?, birthday=?,"
					+ "	address=?, gender=?, phone_number1=?, phone_number2=?, request_course=?, glasses=?,"
					+ "	starting_date=?, reception_date=?, reception_employee=?, reception_name=?, note=?"
					+ "update_date=?,update_time=?,update_id=?, update_count=update_count+1 WHERE STUDENT_ID=? AND DELETE_FLG=0; ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, student.getStudent_name());
			statement.setString(2, student.getStudent_name_phonetic());
			statement.setString(3, student.getBirthday());
			statement.setString(4,student.getAddress() );
			statement.setInt(5, student.getGender());
			statement.setString(6, student.getPhone_number1());
			statement.setString(7, student.getPhone_number2());
			statement.setString(8, student.getRequest_course());
			statement.setInt(9, student.getGlasses());
			statement.setString(10, student.getStarting_date());
			statement.setString(11, student.getReception_date());
			statement.setString(12, student.getReception_employee());
			statement.setString(13, student.getReception_name());
			statement.setString(14, student.getnote());
			statement.setString(15, date);
			statement.setString(16, time);
			statement.setString(17, login_id);
			statement.setString(18, student.getStudent_id());
			
			int result = statement.executeUpdate();
			
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
