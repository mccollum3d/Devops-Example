package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	//private static final Properties props = getJdbcProperties();

	// Private Constructor to enforce usage of factory method
	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		try {
			//return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
			return DriverManager.getConnection(System.getenv("JDBC_URL"), System.getenv("JDBC_USERNAME"), System.getenv("JDBC_PASSWORD"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL Code: " + e.getSQLState());
			throw new RuntimeException("Failed to get database connection");
		}
		
	}

	// Create the method that reads the properties file and returns a properties
	// object
	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Error parsing application.properties file");
		}
		return props;
	}
}
