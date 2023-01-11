package transaction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import databaseinfo.ConnectionProvider;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection con=null;
		try {
		con = ConnectionProvider.getConnection();
		
		// off auto commit
		con.setAutoCommit(false);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter From Account id :-");
		int f_id=Integer.parseInt(br.readLine());
		System.out.println("Enter To Account id :-");
		int t_id=Integer.parseInt(br.readLine());
		System.out.println("Enter Amount :-");
		int amount=Integer.parseInt(br.readLine());
		
		
		//now write prepared statements
		//1. To credit money in account
		PreparedStatement ps1 = con.prepareStatement("update transaction set amount=amount+? where id=?");
		//2. To debit Money in Account
		PreparedStatement ps2 = con.prepareStatement("update transaction set amount=amount-? where id=?");
		
		//now creating statement to valid the amount input by user is valid or not
		PreparedStatement s = con.prepareStatement("select amount from transaction where id=?");
        s.setInt(1,f_id);
	
		ResultSet rs = s.executeQuery();
		
		int curAmt=0;
		//storing current amount into a variable
		if(rs.next()) {
			curAmt = rs.getInt("amount");
		}
		System.out.println("Current Bal="+curAmt);
		//now checking amount with input amount
		if(curAmt>amount) {
			ps1.setInt(1, amount);
			ps1.setInt(2, t_id);
			
			ps1.executeUpdate();
			//exception
//			int i=4/0;
			ps2.setInt(1, amount);
			ps2.setInt(2, f_id);
			ps2.executeUpdate();
			
			//at last commit
			con.commit();
			System.out.println("Transaction succesfull:-");
			System.out.println("Available Balance: " +(curAmt-amount));
		}else {
			System.out.println("you don't have sufficient money");
		}}catch(Exception e) {
			System.out.println(e);
			System.out.println("Rolling back");
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
