package storefileintodatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databaseinfo.ConnectionProvider;

public class StoreFile {
	
	public static void main(String[] args) {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into filetable values(?,?)");
			
			String file = System.getProperty("user.dir");
			file = file+"\\src\\storefileintodatabase\\LogInForm.java";
			
			File f = new File(file);
			ps.setInt(1, 100);

			// to set image
			FileReader fr = new FileReader(f);
				
		    ps.setCharacterStream(2, fr, f.length());
		    
		    int i= ps.executeUpdate();
		    System.out.println(i+"file stored");
		    con.close();
			
			
			
			
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
