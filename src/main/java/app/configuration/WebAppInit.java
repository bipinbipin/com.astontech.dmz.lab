package app.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletContext;

/**
 * Created by Bipin on 11/28/2016.
 */
public class WebAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        //set active profiles
        servletContext.setInitParameter("spring.profiles.active", "springdatajpa");

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfiguration.class);

        //Spring Dispatcher Servlet
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

//        //H2 console
//        String path = "/h2-console";
//        String urlMapping = (path.endsWith("/") ? path + "*" : path + "/*");
//        ServletRegistration.Dynamic h2Console = servletContext.addServlet("h2", new WebServlet());
//        h2Console.setLoadOnStartup(1);
//        h2Console.addMapping(urlMapping);

    }
}
