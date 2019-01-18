package com.teamproject.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.teamproject.configuration.SpringConfiguration;
import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebIntializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {
        
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfiguration.class);
        context.setServletContext(container);

        container.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
    
}


//import com.teamproject.controller.WelcomeController;
//import javax.servlet.Filter;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class SpringWebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {
// 
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] { WelcomeController.class };
//    }
//  
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//  
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//    
//    @Override
//    protected Filter[] getServletFilters() {
//    	Filter [] singleton = { new CORSFilter() };
//    	return singleton;
//	}
// 
//}
