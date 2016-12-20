package in.callkr.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CallkrInitilizer implements WebApplicationInitializer {

	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(CallkrConfiguration.class);
		ctx.setServletContext(arg0);
		ServletRegistration.Dynamic servlet= arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
	}

}
