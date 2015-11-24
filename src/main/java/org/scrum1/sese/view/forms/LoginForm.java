package org.scrum1.sese.view.forms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.scrum1.sese.WicketWebApplication;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.view.page.RoomListPage;

public class LoginForm extends Form {

	public LoginForm(String id, CustomerImpl customer) {
		super(id);
		CompoundPropertyModel model = new CompoundPropertyModel(customer);
		this.setModel(model);
		
		this.add(new TextField("username"));
		this.add(new PasswordTextField("password"));
	}
	
	@Override
	protected void onSubmit() {
		//super.onSubmit();
		CustomerImpl customer = (CustomerImpl) this.getModelObject();
		WicketWebApplication app = (WicketWebApplication) this.getApplication();
		// Check credentials
		System.out.println("Checking credentials " + customer.getUsername() + " " + customer.getPassword());
		PageParameters param = new PageParameters();
		param.add("username", customer.getUsername());
		getRequestCycle().setResponsePage(RoomListPage.class, param);
	}

}
