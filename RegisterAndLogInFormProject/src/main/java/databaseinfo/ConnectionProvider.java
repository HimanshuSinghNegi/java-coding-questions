package databaseinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	 static Connection con = null;
	 
	 public static Connection getConnection() {
		 try {
			Class.forName(DatabaseInfo.DATABASE_DRIVER);
			con = DriverManager.getConnection(DatabaseInfo.DATABSE_URL,DatabaseInfo.DATABASE_USER,DatabaseInfo.DATABASE_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return con;
		 
	 }
}
