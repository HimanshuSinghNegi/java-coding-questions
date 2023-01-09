package forms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.UserDetailDao;
import utils.RecordCount;

public class UserInfo {
	JFrame frame;
	JLabel label;
	DefaultTableModel defaultTableModel;
	public Object data[][] =new Object[RecordCount.getRecordCount()][RecordCount.getRecordCount()];
	JTable table;
	public UserInfo(){
		frame=new JFrame();
		//here getting all records inside 2d array
		UserDetailDao ud = new UserDetailDao();
	    data=ud.getDetails();
	    
		String column[]={"ID","NAME","PASSWORD"};   
		
		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,500,500);          
		JScrollPane sp=new JScrollPane(jt);    
		frame.add(sp);          
		frame.setSize(500,500);   
		frame.setLocation(400, 400);
		frame.setVisible(true); 
		    
}
}
