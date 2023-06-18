package utils;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class GetSetDataBaseValues {
	public Statement stmt;
	public ResultSet resset;
	public DataBaseConnection dbc;
	
	public void SetDataIntoDB(int userid, String username, String userpswrd) throws SQLException {
		try {
			dbc = DataBaseConnection.getInstance();
			stmt = dbc.getConnection().createStatement();
			
			
			boolean canAdd = true;
			String verifyQuery = "SELECT sn FROM Credentials";
			resset = stmt.executeQuery(verifyQuery);
			while(resset.next()) {
				System.out.println(resset.getString(1));
				if(resset.getString(1).equals(userid)) {
					canAdd = false;
					break;
				}
			}
			if(canAdd == true) {
				String insertdata = "INSERT INTO Credentials (sn, username, userpswrd) VALUES ('"+userid+"', '"+username+"', '"+userpswrd+"')";
				stmt.executeUpdate(insertdata);
				System.out.println("User entered Successfully");
			} else System.out.println("User Id exists can not proceed with entering the content");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(dbc != null) System.out.println(dbc);
		}
	}
	
	public void GetDataFromDB() throws SQLException {
		try {
			stmt = dbc.getConnection().createStatement();
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
			if(dbc != null) System.out.println(dbc);
		}
	}
	
}
