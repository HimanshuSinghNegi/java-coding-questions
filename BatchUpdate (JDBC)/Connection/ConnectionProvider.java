package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import databaseInfo.DatabaseInfo;

public class ConnectionProvider {
    static Connection con=null;
	public static Connection getConnection() {
		
    	try {	Class.forName(DatabaseInfo.DATABASE_DRIVER);
				con = DriverManager.getConnection(DatabaseInfo.DATABASE_URL, DatabaseInfo.DATABASE_USERNAME, DatabaseInfo.DATABASE_PASSWORD);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return con;
		} 
    	
    	
    }
