package forms;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import listeners.RegisterListener;

public class RegisterForm {
	public JFrame frame;
	JLabel name,password;
	public JTextField t_name,t_pass;
	public JButton register,cancel;
     public RegisterForm(){
    	 frame = new JFrame("Register Form");
    	 frame.setSize(300, 300);
    	 frame.setVisible(true);
    	 frame.setLayout(new FlowLayout());
    	 name = new JLabel("Enter your name ");
    	 password =new JLabel("Enter your password ");
    	 t_name= new JTextField(10);
    	 t_pass= new JTextField(10);
    	 frame.add(name);
    	 frame.add(t_name);
    	 frame.add(password);
    	 frame.add(t_pass);
    	 frame.setLocation(800, 400);
    	 register = new JButton("Register");
    	 cancel = new JButton("Cancel");
    	 frame.add(register);
    	 frame.add(cancel);
    	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	 
    	 RegisterListener l = new RegisterListener(this);
    	 register.addActionListener(l);
    	 cancel.addActionListener(l);
	    	
    	 
     }

}
