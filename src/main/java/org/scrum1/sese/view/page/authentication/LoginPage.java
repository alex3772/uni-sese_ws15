package org.scrum1.sese.view.page.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SavedRequest;
import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

public class LoginPage extends WebPage{
	
	private static Logger logger = Logger.getLogger(LoginPage.class);
	
	public LoginPage() {
		add(new LoginForm("loginForm"));
	}
	
	private class LoginForm extends Form<Void> {
		
		private transient RequestCache requestCache = new HttpSessionRequestCache();
		
		private String username;
		
		private String password;
		
		public LoginForm(String id) {
			super(id);
			setModel(new CompoundPropertyModel(this));
			add(new RequiredTextField<String>("username"));
			add(new PasswordTextField("password"));
			add(new FeedbackPanel("feedback"));
		}
		
		@Override
		protected void onSubmit() {
			HttpServletRequest servletRequest = (HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest();
			String originalUrl = getOriginalUrl(servletRequest.getSession());
			AuthenticatedWebSession session = AuthenticatedWebSession.get();
			
			if(session.signIn(username, password)) {
				if(originalUrl != null) {
					logger.info(String.format("Redirection to %s", originalUrl));
					throw new RedirectToUrlException(originalUrl);
				} else {
					logger.info("Redirecting to home page");
					setResponsePage(getApplication().getHomePage());
				}
			} else {
				error("Login failed due to invalid credentials");
			}
		}

		
		/**
		 * Returns the URL the user tried to access without credentials
		 * Before redirecting to the login page it has been stored by spring
		 * 
		 * @return the URL the user needs gets redirected on successfull authentication 
		 */
		private String getOriginalUrl(HttpSession session) {
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			if(savedRequest != null) {
				return savedRequest.getRequestURI();
			}
			return null;
		}
	}
}
