package retriveimagefromdatabase;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseinfo.ConnectionProvider;

public class RetriveImage {
 public static void main(String[] args) {
	Connection con=null;
	try {
		con= ConnectionProvider.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from imagetable");
		ResultSet rs = ps.executeQuery();
		rs.next();
		Blob b = rs.getBlob(2);
		byte barr[]= new byte[(int) b.length()]; //an empty arr to store image bytes
		barr = b.getBytes(1,(int) b.length());
		
		//folder path where we want to store image
		String file = System.getProperty("user.dir");
		file=file+"\\src\\retriveimagefromdatabase\\nartuo.jpeg";
		
		//now retrieving file by the help of FileOutputStream class
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(barr);
		fo.close();
		System.out.println("image retrived successfully");
		
	}catch(Exception e) {
	System.out.println(e);
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
