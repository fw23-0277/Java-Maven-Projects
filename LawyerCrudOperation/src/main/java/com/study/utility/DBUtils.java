package com.study.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	
	 static String URL , USERNAME , PASSWORD ;
	 
	 static {
		 ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		 URL = rb.getString("url");
		 USERNAME = rb.getString("username");
		 PASSWORD = rb.getString("password");
		 
	 }
	 
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public static void createLawyerTable() {
		
		String createTable = "CREATE TABLE IF NOT EXISTS LAWYER ("
				+ "id INT PRIMARY KEY,"
				+ "name VARCHAR(20) NOT NULL,"
				+ "email VARCHAR(20) UNIQUE NOT NULL,"
				+ "addres VARCHAR(50),"
				+ "experience int );";
				
	
		try (Connection connection = createConnection()){
			
			PreparedStatement prepareStatement = connection.prepareStatement(createTable);
			prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
