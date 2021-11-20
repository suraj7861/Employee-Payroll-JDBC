package com.empJdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class EmployeeDBConnection {

	//connection method
	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll_service123?useSSL=false";
		String userName = "root";
		String password = "Suraj@7861";
		Connection connection;
		System.out.println("Connecting to database: " + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is successful! " + connection);
		return connection;
	}

	private List<EmployeePayrollData> getEmployeePayrollDataUsingDB(String sql) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			java.sql.Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				double salary = result.getDouble("salary");
				LocalDate startDate = result.getDate("start").toLocalDate();
				employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	// read data from data base use queries
	public List<EmployeePayrollData> readData() {
		String sql = "SELECT * FROM employee_payroll_service123";
		return getEmployeePayrollDataUsingDB(sql);
	}

}


