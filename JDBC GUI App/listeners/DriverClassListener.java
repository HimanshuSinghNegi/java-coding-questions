package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import drivercode.DriverClass;
import forms.LogInForm;
import forms.RegisterForm;
import forms.UserInfo;

public class DriverClassListener implements ActionListener{
	DriverClass driverClass;
	public DriverClassListener(DriverClass driverClass) {
		this.driverClass=driverClass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==driverClass.logIn) {
			LogInForm lf = new LogInForm();
		}else if(e.getSource()==driverClass.register) {
			RegisterForm rf = new RegisterForm();
		}else if(e.getSource()==driverClass.update){
			System.out.println("update");
		}else if(e.getSource()==driverClass.delete) {
			System.out.println("delete");
		}else if(e.getSource()==driverClass.show) {
			UserInfo u = new UserInfo();
				
			
		}
		
	}

}
