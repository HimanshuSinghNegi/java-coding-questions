package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import beans.LogInBean;
import dao.LogInDao;
import dao.RegisterDao;
import forms.LogInForm;
import forms.RegisterForm;
import forms.UpdateUserDetails;

public class LogInListener implements ActionListener{
    LogInForm loginForm;
   
  public LogInListener( LogInForm loginForm){
    	this.loginForm=loginForm;
    }
   
  @Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginForm.login) {
//			System.out.println("login");
			String name = loginForm.t_name.getText();
			String password = loginForm.t_password.getText();
			//here checking condition
			if(!name.equals("")&&!password.equals("")) {
			LogInBean lb = new LogInBean(name,password);
			LogInDao dao = new LogInDao();
			dao.userLogin(lb);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill all the fields");
			}
			
		}
		else if(e.getSource()==loginForm.cancel) {
//			System.out.println("cancel");
			loginForm.t_name.setText("");
			loginForm.t_password.setText("");
		}
		else if(e.getSource()==loginForm.register) {
			RegisterForm r = new RegisterForm();
			
		}else if(e.getSource()==loginForm.update) {
			UpdateUserDetails u = new UpdateUserDetails();
		}
		
	}
}
