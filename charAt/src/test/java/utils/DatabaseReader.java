package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseReader {
	static Connection con = null;
	private static Statement stmt ;
	public static String DB_URL = "jdbc:mysql://localhost/sampleTDD";
	public static String DB_Username = "root";
	public static String DB_Password = "";
	public static ResultSet resset;
	
	@SuppressWarnings("deprecation")
	private void SetupDBConnection() throws Exception, InstantiationException, IllegalAccessException {
		try {
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			con = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
			stmt = con.createStatement();
		} catch(Exception e) {
			System.out.println("Database errors " + e.getStackTrace());
		}
	}
	
	public void GetDataFromDatabase() throws SQLException {
		try {
			SetupDBConnection();
			String query = "Select * From Credentials";
			resset = stmt.executeQuery(query);
			while(resset.next()) {
				System.out.println("User SN : " + resset.getString(1));
				System.out.println("Username : " + resset.getString(2));
				System.out.println("Password : " + resset.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
	}
	
	public void SetDataInDatabase() throws SQLException{
		try {
			SetupDBConnection();
			boolean canAdd = true;
			String verifyQuery = "SELECT sn FROM Credentials";
			resset = stmt.executeQuery(verifyQuery);
			while(resset.next()) {
				System.out.println(resset.getString(1));
				if(resset.getString(1).equals("7")) {
					canAdd = false;
					break;
				}
			}
			if(canAdd == true) {
				String insertdata = "INSERT INTO Credentials (sn, username, userpswrd) VALUES ('7', 'Rushabh', 'Rushi1234')";
				stmt.executeUpdate(insertdata);
				System.out.println("User entered Successfully");
			} else System.out.println("User Id exists can not proceed with entering the content");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
	}
}
