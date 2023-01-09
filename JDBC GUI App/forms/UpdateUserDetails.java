package forms;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import listeners.UpdateUserDetailListener;

public class UpdateUserDetails {
    JFrame frame;
    JLabel id,name,password;
    JTextField t_id,t_name,t_pass;
    JButton update;
	public UpdateUserDetails(){
		frame = new JFrame("Update User Details");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(100,200,300,300);
		
		id=new JLabel("Enter your ID ");
		name = new JLabel("Enter your name ");
		password = new JLabel("Enter your New password ");
		t_id= new JTextField(10);
		t_name =new JTextField(10);
		t_pass = new JTextField(10);
		update = new JButton("Update");
		
		frame.add(id);
		frame.add(t_id);
		frame.add(name);
		frame.add(t_name);
		frame.add(password);
		frame.add(t_pass);
		frame.add(update);
		
		UpdateUserDetailListener ul = new UpdateUserDetailListener(this);
		update.addActionListener(ul);
	}

}
