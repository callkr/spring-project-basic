package in.callkr.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="in.callkr")
public class CallkrConfiguration extends WebMvcConfigurerAdapter{
	/*
     * Configure View Resolver
     */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setViewClass(JstlView.class);
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");
		return viewresolver;	
	}

	/*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     *
     */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registery){
	registery.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	 /*
     * Configure MessageSource to provide internationalized messages
     *
     */
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
}
