package retreivefilefromdatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

import databaseinfo.ConnectionProvider;

public class RetreiveFile {
	public static void main(String[] args) {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from filetable");
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Blob c =(Blob) rs.getBlob(2);
			InputStream r = c.getBinaryStream();
			
			
			String file = System.getProperty("user.dir");
			file = file+"\\src\\retreivefilefromdatabase\\RetrivedFile.java";
			
			FileWriter f = new FileWriter(file);
			while(true) {
				int i=r.read();
				if(i==-1)
					break;
				f.write((char)i);
			}
			f.close();
			con.close();
			
		  System.out.println("file retreived successfully");
		    
			
			} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}}
