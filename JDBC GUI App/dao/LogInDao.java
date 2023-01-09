package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.LogInBean;
import databaseinfo.ConnectionProvider;
// inside dao class we write code to execute query
public class LogInDao {
	
	public void userLogin(LogInBean loginBean) {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where name=? and pass=?");
			
			ps.setString(1,loginBean.getName());
			ps.setString(2,loginBean.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("valid");
			}else {
				System.out.println("not valid");
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
