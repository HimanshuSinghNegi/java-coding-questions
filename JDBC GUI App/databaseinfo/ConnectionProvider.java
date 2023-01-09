package databaseinfo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con =null;
	private ConnectionProvider() {
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(DBInfo.DATABASE_DRIVER);
			con= DriverManager.getConnection(DBInfo.DATABASE_URL,DBInfo.DATABASE_USERNAME,DBInfo.DATABASE_PASS);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
