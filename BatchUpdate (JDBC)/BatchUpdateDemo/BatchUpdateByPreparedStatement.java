package BatchUpdateDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Connection.ConnectionProvider;

public class BatchUpdateByPreparedStatement {
	public static String getSystemTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-m-yyyy hh:mm:ss:SS");
		String str = format.format(date);
		return str;
	}
	
	public static void main(String[] args) {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into user (name,pass,datetime) values (?,?,?)");
			ps.setString(1, "Himanshu");
				ps.setString(2, "himanshu");
				ps.setString(3, getSystemTime());
				//1st batch
				ps.addBatch();
				ps.setString(1, "Shyan");
				ps.setString(2, "shyam");
				ps.setString(3, getSystemTime());
				//2nd batch
				ps.addBatch();
				
				ps.setString(1, "Yolo");
				ps.setString(2, "yolo");
				ps.setString(3, getSystemTime());
				//3rd batch
				ps.addBatch();
				int i[]=ps.executeBatch(); //this will return a array of size no. of batch
				System.out.println(i.length);
			}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}}
	
