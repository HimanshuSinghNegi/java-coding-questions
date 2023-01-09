package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseinfo.ConnectionProvider;
import utils.RecordCount;

public class UserDetailDao {
	
	public Object[][] getDetails() {
		Object arr[][]= new Object[RecordCount.getRecordCount()][RecordCount.getRecordCount()];
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from user");
			
			ResultSet rs1 = ps.executeQuery("select max(id) as max from user");
			String max="";
			if(rs1.next()) {
			  max = rs1.getString("max");	
			}
//			System.out.println(max);
			int i=0;
			int j=0;
			ResultSet rs = ps.executeQuery();
			while(rs.next() ) {
			j=0;
			arr[i][j++]=rs.getString("id");
			arr[i][j++]=rs.getString("name");
			arr[i][j]=rs.getString("pass");
			i++;
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
		return arr;
	}

}
