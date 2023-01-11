package storefileintodatabase;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import listeners.LogInListener;
public class LogInForm {
		
	public JFrame frame;
	public JButton login;
	public JButton cancel;
	public JButton register,update;
	public JLabel name,password;
	public JTextField t_name;
	public JPasswordField t_password;
	JPanel panel;
	public LogInForm(){
	    	frame= new JFrame();
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	
	    	panel = new JPanel();
	    	name = new JLabel("Enter your Name");
	    	password = new JLabel("Enter Your Passcode");
	    	t_name = new JTextField(10);
	    	t_password = new JPasswordField(10);
	    
	    	
	    	login = new JButton("Login");
	    	cancel = new JButton("Cancel");
	    	register= new JButton("Register");
	    	update= new JButton("Update");
	    	
	    	panel.add(name);
	    	panel.add(t_name);
	    	panel.add(password);
	    	panel.add(t_password);
	    	panel.add(login);
	    	panel.add(cancel);
	    	panel.add(register);
//	    	panel.add(update);
	    	panel.setBackground(Color.CYAN);
	    
	    	panel.setLayout(new  FlowLayout());
//	    	frame.setLayout(new FlowLayout());
	    	frame.add(panel);
//	    	LogInListener l = new LogInListener(this);
//	    	login.addActionListener(l);
//	    	cancel.addActionListener(l);
//	    	register.addActionListener(l);
//	    	update.addActionListener(l);
	    	
	    	frame.setSize(300,300);
	    	frame.setLocation(800, 400);
	    	frame.setVisible(true);
	    	
	    	
	   }


}
