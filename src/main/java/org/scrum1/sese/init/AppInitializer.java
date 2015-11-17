package org.scrum1.sese.init;

import java.util.EnumSet;

import javax.servlet.*;

import org.apache.wicket.protocol.http.WicketFilter;
import org.scrum1.sese.WicketWebApplication;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class AppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(SpringBootWebSecurityConfiguration.class);
        FilterRegistration.Dynamic springSecurityFilterChainReg = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChainReg.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ERROR, DispatcherType.REQUEST), false, "/*");
        servletContext.addListener(new ContextLoaderListener(root));
        WicketFilter wicketFilter = new WicketFilter(new WicketWebApplication()) {
            @Override
            public void init(boolean isServlet, FilterConfig filterConfig) throws ServletException {
                setFilterPath("");
                super.init(isServlet, filterConfig);
            }
        };

        FilterRegistration.Dynamic wicketFilterReg = servletContext.addFilter("wicketFilter", wicketFilter);
        wicketFilterReg.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "*");
		
	}

}
