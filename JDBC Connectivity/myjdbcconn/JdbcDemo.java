package myjdbcconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcDemo {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	try {
		//create connenection
		Connection con = ConnectionProvider.getConnection();
		//now create prepared Statement to execute query
		PreparedStatement ps = con.prepareStatement("insert into student (name,address,dep) values (?,?,?)");
		
		while(true) {
		System.out.println("Do you want to insert data :-\n1.(Press 'y' for yes) \n 2. (Press \"n\" for No)");
		System.out.println("Enter your choice :-");char choice = sc.next().charAt(0);
		if(choice=='n')
			break;
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your address");
		String address = sc.next();
		System.out.println("Enter your dep");
		String dep = sc.next();
		
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, dep);
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("inserted successfully ...");
		else
			System.out.println("not inserted ...");
		
		}
		
		//now code to retreive data from database
		ResultSet rs  = ps.executeQuery("select * from student");
		System.out.println("your data:-");
		System.out.println("1.ID\t\t\\t2.Name\t\t3.Address\t\t4.Dep");
		while(rs.next()) {
			System.out.println(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("address")+"\t"+rs.getString("dep"));
		}
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
