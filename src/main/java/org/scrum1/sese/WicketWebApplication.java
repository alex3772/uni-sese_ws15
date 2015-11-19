package org.scrum1.sese;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.scrum1.sese.view.page.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ThemeProvider;
import de.agilecoders.wicket.less.BootstrapLess;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchTheme;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchThemeProvider;

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
		// TODO Auto-generated method stub
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		configureBootstrap();
        addResourceReplacement(JQueryResourceReference.get(),
                new UrlResourceReference(
                        Url.parse("http://code.jquery.com/jquery-1.11.0.min.js")));
        
        /*mountPage("account", UserAccountPage.class);
        mountPage("fileUpload", FileUploadPage.class);*/
	}

	private void configureBootstrap() {
		// TODO Auto-generated method stub
		final IBootstrapSettings settings = new BootstrapSettings();
        settings.useCdnResources(true);
        
        final ThemeProvider themeProvider = new BootswatchThemeProvider(BootswatchTheme.Spacelab);
        settings.setThemeProvider(themeProvider);
        
        Bootstrap.install(this, settings);
        BootstrapLess.install(this);
	}
}
