package org.scrum1.sese.view.forms;

import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.scrum1.sese.WicketWebApplication;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;

public class RegisterForm extends Form{

	public RegisterForm(String id, CustomerImpl customer) {
		super(id);
		CompoundPropertyModel model = new CompoundPropertyModel(customer);
		this.setModel(model);
		
		this.add(new TextField("name"));
		this.add(new TextField("surname"));
		this.add(new TextField("username"));
		this.add(new PasswordTextField("password"));
		this.add(new TextField("phone"));
		this.add(new EmailTextField("email"));
		this.add(new TextField("street"));
		this.add(new TextField("city"));
		this.add(new TextField("zipCode"));
		this.add(new TextField("companyName"));
		this.add(new TextField("fax"));
		this.add(new TextField("web"));
		this.add(new TextField("note"));		
	}
	
	@Override
	protected void onSubmit() {
		CustomerImpl customer = (CustomerImpl) this.getModelObject();
		WicketWebApplication app = (WicketWebApplication) this.getApplication();
		
		System.out.println("Submitting Register Form");
		PageParameters param = new PageParameters();
		param.add("customer", customer);
	}

}