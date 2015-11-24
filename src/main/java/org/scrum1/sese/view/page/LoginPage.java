package org.scrum1.sese.view.page;

import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.view.forms.LoginForm;

public class LoginPage extends BasePage {
	
	public LoginPage(CustomerImpl customer) {
		this.add(new LoginForm("login_form", customer));
	}

}
