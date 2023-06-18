package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static DataBaseConnection instance;
	private Connection con;
	private String DB_URL = "jdbc:mysql://localhost/sampleTDD";
	private String DB_Username = "root";
	private String DB_Password = "";
	private String dbClass = "com.mysql.cj.jdbc.Driver";
	private DataBaseConnection() throws SQLException{
		try {
			Class.forName(dbClass);
			this.con = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
		}catch(Exception e) {
			System.out.println("SQL Exceptions may occur here: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public static DataBaseConnection getInstance() throws SQLException{
		if(instance == null) instance = new DataBaseConnection();
		else if (instance.getConnection().isClosed()) instance = new DataBaseConnection();
		return instance;
	}
}
