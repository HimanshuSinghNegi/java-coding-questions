package drivercode;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.DriverClassListener;
//run this first
public class DriverClass {
	  JFrame frame;
	  public JButton logIn,register,update,delete,show;
	  
      DriverClass(){
    	  frame = new JFrame("Driver Frame");
    	  frame.setLayout(new FlowLayout());
    	  logIn = new JButton("LogIn");
    	  register = new JButton("Register");
    	  update = new JButton("update");
    	  delete = new JButton("delete");
    	  show = new JButton("show");
    	  
    	  
    	  
    	 
    	  frame.add(logIn);

    	  frame.add(register);
    	  frame.add(show);
    	  frame.add(update);
    	  frame.add(delete);
    	  
    	  DriverClassListener dl = new DriverClassListener(this);
    	  logIn.addActionListener(dl);
    	  register.addActionListener(dl);
    	  update.addActionListener(dl);
    	  delete.addActionListener(dl);
    	  show.addActionListener(dl);
    	  
    	  
    	  frame.setSize(300, 500);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setLocation(800, 400);
    	  frame.setVisible(true);
    	  
      }
	public static void main(String[] args) {
	    DriverClass d = new DriverClass();

	}

}
