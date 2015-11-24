package org.scrum1.sese;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;
import org.scrum1.sese.view.page.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class for starting the application.
 * In eclipse just open this file and click on run.
 */
@EnableAutoConfiguration
@ComponentScan
public class WicketWebApplication extends WebApplication {

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
		return RuntimeConfigurationType.DEVELOPMENT;
	}
	
	@Override
	protected void init() {
		super.init();
	}
}
