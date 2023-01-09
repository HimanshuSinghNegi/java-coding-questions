package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.LogInBean;
import databaseinfo.ConnectionProvider;

public class RegisterDao {

	public void userRegister(LogInBean registerBean) {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into user (name,pass) values (?,?)");
			ps.setString(1, registerBean.getName());
			ps.setString(2, registerBean.getPassword());
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("something went wrong");
			}
		} catch (SQLException e) {
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
 	}
	
	
}
