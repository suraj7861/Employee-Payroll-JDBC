package com.empJdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeeDBConnection {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee JDBC program");

		String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll?useSSL=false";
		String userName = "root";
		String password = "Suraj@7861";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded...");		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		checkDriver();
		
		Connection connection;
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successful..!!! " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//checking the driver is loaded or not
	public static void checkDriver() {

		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println("Driver Name : " + driver);
		}
	}
}

