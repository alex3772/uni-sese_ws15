package org.scrum1.sese;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AnnotationsRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.scrum.sese.authentication.AuthenticatedPage;
import org.scrum.sese.authentication.BasicAuthenticationSession;
import org.scrum.sese.authentication.SignInPage;
import org.scrum1.sese.view.page.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class WicketWebApplication extends AuthenticatedWebApplication {

	// TODO source: https://github.com/Pentadrago/spring-boot-example-wicket

	private final static Logger logger = LoggerFactory.getLogger(WicketWebApplication.class);

	@Override
	public Class<? extends Page> getHomePage() {
		return MainPage.class;
	}

	public static void main(String[] args) {
		SpringApplication.run(WicketWebApplication.class, args);
	}

	@Override
	public RuntimeConfigurationType getConfigurationType() {
		return super.getConfigurationType().DEPLOYMENT;
	}
	
	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		getSecuritySettings().setAuthorizationStrategy(new AnnotationsRoleAuthorizationStrategy(this));
		mountPage("/", MainPage.class);
		mountPage("/login", SignInPage.class);
		mountPage("/ok", AuthenticatedPage.class);
		
	}

	
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return BasicAuthenticationSession.class;
	}

	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}
}
