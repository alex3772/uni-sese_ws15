package org.scrum.sese.authentication;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class AuthenticatedPage extends WebPage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void onConfigure() {
		super.onConfigure();
		AuthenticatedWebApplication app = (AuthenticatedWebApplication)Application.get();
		// if user isn't signed in redirect him to signin page
		if(!AuthenticatedWebSession.get().isSignedIn()) {
			app.restartResponseAtSignInPage();
		}
	}
	
	protected void onInitialize() {
		super.onInitialize();
		add(new Link<String>("goToHomePage") {
			@Override
			public void onClick() {
				setResponsePage(getApplication().getHomePage());				
			}			
		});
		
		add(new Link<String>("logOut") {
			@Override
			public void onClick() {
				AuthenticatedWebSession.get().invalidate();
				setResponsePage(getApplication().getHomePage());
			}
		});
	};

}
