package app.cal.schedule.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		List<Class<?>> configBeans = new LinkedList<>();
		configBeans.addAll( Arrays.asList(AppConfig.class, 
							BusinessServiceConfig.class,
							CommandHandlerConfig.class,
							DaoConfig.class,
							DataSourceConfig.class,
							HibernateConfig.class,
							ReadServicesConfig.class
						   ));
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
		registerConfigBeans(ctx, configBeans);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	
	private void registerConfigBeans( AnnotationConfigWebApplicationContext ctx, List<Class<?>> configBeans){
		
		Class<?> [] annotatedConfigClasses = new Class[configBeans.size()];
		configBeans.toArray(annotatedConfigClasses);
		ctx.register(annotatedConfigClasses);
	}

}
