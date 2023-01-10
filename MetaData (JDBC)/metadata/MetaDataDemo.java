package meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import databaseinfo.ConnectionProvider;

public class MetaDataDemo {
	public static void main(String[] args) {
		Connection con = ConnectionProvider.getConnection();
		//DatabaseMetaData info
		try {
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("Database Information:-");
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			System.out.println(dmd.getTableTypes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ResultSetMetaData info
		
		try {
			Statement s = con.createStatement();
			ResultSet rs =s.executeQuery("select * from user");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("ResultSet Information :-");
			System.out.println(rsmd.getColumnCount());
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnName(2));
			System.out.println(rsmd.getColumnType(1));
			System.out.println(rsmd.getTableName(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
