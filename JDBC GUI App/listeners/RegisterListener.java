package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import beans.LogInBean;
import dao.RegisterDao;
import forms.LogInForm;
import forms.RegisterForm;

public class RegisterListener implements ActionListener{
	 RegisterForm registerForm;
	  public RegisterListener( RegisterForm registerForm){
		  	this.registerForm=registerForm;
		  }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerForm.register) {
			String name =registerForm.t_name.getText();
			String pass=registerForm.t_pass.getText();
			if(!name.equals("")&&!pass.equals("")) {
				LogInBean rb = new LogInBean(name,pass);
				
			 int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to Register...");
			 if(i!=1) {
				 RegisterDao rd = new RegisterDao();
				 rd.userRegister(rb);
				 JOptionPane.showMessageDialog(null,"Now You Can LogIn");
				 LogInForm lf = new LogInForm();
				 registerForm.frame.dispose();
			 } else {
				 JOptionPane.showMessageDialog(null,"You are not Registered");
			 }
			 }else {
				JOptionPane.showMessageDialog(null, "Please fill all the fields");
			}
		}else if(e.getSource()==registerForm.cancel) {
			registerForm.t_name.setText("");
			registerForm.t_pass.setText("");
		}
		
	}
	  
}
