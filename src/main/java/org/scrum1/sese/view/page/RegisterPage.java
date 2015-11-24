package org.scrum1.sese.view.page;

import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.view.forms.LoginForm;
import org.scrum1.sese.view.forms.RegisterForm;

public class RegisterPage extends BasePage {
	
	public RegisterPage(CustomerImpl customer) {
		this.add(new RegisterForm("register_form", customer));
		
	}

}
