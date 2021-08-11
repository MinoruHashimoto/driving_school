package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class M_EmployeeDAO extends parentDAO {
	public boolean findby(String employee_code, String password)  {

		try {
			Connection connection = DriverManager.getConnection(LOCAL_DATABASE_URL, "postgres", "kanri");

			Employee employee = null;

			String sql = "SELECT EMPLOYEE_CODE, PASSWORD FROM M_EMPLOYEE "
					+ "WHERE EMPLOYEE_CODE=? AND PASSWORD=?; ";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, employee_code);
			statement.setString(2, password);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				employee_code = result.getString("EMPLOYEE_CODE");
				password = result.getString("PASSWORD");
				employee = new Employee(employee_code, password);
			}

			if (employee != null) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
