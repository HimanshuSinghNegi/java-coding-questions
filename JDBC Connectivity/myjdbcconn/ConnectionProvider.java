package myjdbcconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con =null;
	private ConnectionProvider() {
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(DatabaseDetails.DATABASE_DRIVER);
			con= DriverManager.getConnection(DatabaseDetails.DATABASE_URL,DatabaseDetails.DATABASE_USERNAME,DatabaseDetails.DATABASE_PASS);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
