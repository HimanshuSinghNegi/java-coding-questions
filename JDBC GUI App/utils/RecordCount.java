package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databaseinfo.ConnectionProvider;

public class RecordCount {
	public static int getRecordCount() {
		Object arr[][]= new Object[11][11];
		Connection con = ConnectionProvider.getConnection();
		int max=0;
		try {
			Statement statement = con.createStatement();
			
			ResultSet rs1 = statement.executeQuery("select max(id) as max from user");
			
			if(rs1.next()) {
			  max = rs1.getInt("max");	
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return max;

}}
