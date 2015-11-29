package org.scrum1.sese.view.forms;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.scrum1.sese.WicketWebApplication;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.service.CustomerService;
import org.scrum1.sese.service.EmployeeService;
import org.scrum1.sese.view.page.MainPage;
import org.scrum1.sese.view.page.RoomListPage;

public class LoginForm extends Form {
	
	@SpringBean
	CustomerService customerService;
	
	@SpringBean
	EmployeeService employeeService;

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
		System.out.println("On Submit, now authenticating");
		boolean authenticated = authenticate(customer.getUsername(), customer.getPassword());
		if(authenticated) {
			getRequestCycle().setResponsePage(MainPage.class);
		}
			
		//PageParameters param = new PageParameters();
		//param.add("username", customer.getUsername());
		//getRequestCycle().setResponsePage(RoomListPage.class);
	}

	private boolean authenticate(String username, String password) {
		WebSession session = WebSession.get();
		boolean authResult = authResult = this.employeeService.authenticate(username, password);
		if(!authResult) {
			authResult = this.customerService.authenticate(username, password);
		}
		return authResult;		
	}

}
