package BatchUpdateDemo;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Connection.ConnectionProvider;

public class BatchUpdateDemo {
	
	public static String getSystemTime() {
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-m-yyyy hh:mm:ss:SS");
		String str = format.format(date);
		return str;
	}
	
	public static void main(String[] args) {
		Connection con = ConnectionProvider.getConnection();
		try {
			Statement s = con.createStatement();
			
			String str1;
			try {
				str1 = "insert into user (name,pass,datetime) values ('admin','admin','"+getSystemTime()+"')";
				String str2 ="update user set name='rama' where pass='admin'";
//				String str3= "delete from user where name='admin'";
				s.addBatch(str1);
//				s.addBatch(str3);
				s.addBatch(str2);
				s.executeBatch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				con.close();
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
