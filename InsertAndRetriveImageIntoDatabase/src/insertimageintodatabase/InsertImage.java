package insertimageintodatabase;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databaseinfo.ConnectionProvider;

public class InsertImage {
	
public static void main(String[] args) {
	Connection con=null;
	
	
	try {
		con = ConnectionProvider.getConnection();
		//getting path of Image
		String file = System.getProperty("user.dir");
		file = file+"\\src\\insertimageintodatabase\\OIP.jpeg";
		
		PreparedStatement  ps = con.prepareStatement("insert into imagetable values (?,?)");
		
		FileInputStream fi = new FileInputStream(file);
		ps.setString(1, "naruto");
		ps.setBinaryStream(2, fi,fi.available());
		
		int i = ps.executeUpdate();
		System.out.println(i+"img inserted");
	} catch (Exception e) {
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
