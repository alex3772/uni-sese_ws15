package org.scrum1.sese.view.forms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;

public class CustomerForm extends Form{

	private TextField<String> firstnameField;
	private TextField<String> surnameField;
	private TextField<String> usernameField;
	private PasswordTextField passwordField;
	private TextField<String> genderField;
	private TextField<String> companynameField;
	private TextField<String> faxField;
	private TextField<String> webField;
	private TextField<String> noteField;
	private TextField<String> discountField;
	
	public CustomerForm(String id, CustomerImpl customer) {
		super(id);
		
		CompoundPropertyModel<Customer> model = new CompoundPropertyModel<Customer>(customer);
		setModel(model);
		
		
		setMarkupId("customerForm");
		
		firstnameField = new TextField<>("firstname", Model.of(""));
		surnameField = new TextField<>("surname", Model.of(""));
		usernameField = new TextField<>("username", Model.of(""));
		passwordField = new PasswordTextField("password", Model.of(""));
		genderField = new TextField<>("gender", Model.of(""));
		companynameField = new TextField<>("companyname", Model.of(""));
		faxField = new TextField<>("fax", Model.of(""));
		webField = new TextField<>("web", Model.of(""));
		noteField = new TextField<>("note", Model.of(""));
		discountField = new TextField<>("discount", Model.of(""));
		
		add(firstnameField);
		add(surnameField);
		add(usernameField);
		add(passwordField);
		add(genderField);
		add(companynameField);
		add(faxField);
		add(webField);
		add(noteField);
		add(discountField);
		
	}
	
	@Override
	protected void onSubmit() {
		System.out.println("Submit");
		
	}
	
	

}
