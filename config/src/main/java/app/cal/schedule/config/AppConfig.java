package app.cal.schedule.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import app.cal.scheduler.converter.AppJacksonHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"app.cal.schedule"},
			   excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=AppConfig.class))
public class AppConfig extends WebMvcConfigurerAdapter {
	
  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	
	}
	
	
	@Bean
	public ContentNegotiationManagerFactoryBean cnManager(){
		ContentNegotiationManagerFactoryBean cmFB = new ContentNegotiationManagerFactoryBean();
		cmFB.setDefaultContentType(MediaType.APPLICATION_JSON);
		cmFB.setFavorParameter(true);
		cmFB.setFavorPathExtension(true);
		cmFB.setIgnoreAcceptHeader(true);
		Properties mediaTypes = new Properties();
		mediaTypes.put(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE);
		mediaTypes.put(MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XML_VALUE);
		mediaTypes.put(MediaType.TEXT_XML_VALUE, MediaType.TEXT_XML_VALUE);
		mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
		mediaTypes.put("xml", MediaType.APPLICATION_XML_VALUE);		
		return cmFB;
	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping(){
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setOrder(2);
		handlerMapping.setContentNegotiationManager(cnManager().getObject());
		return handlerMapping;
	}
	
	@Bean
	public HandlerMapping viewControllerHandlerMapping(){
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(1);
		
		Map<String, String> jspMapping = jspMapping().getConfig();
		Map<String, ParameterizableViewController> jspViewBeans = new HashMap<>();
		ParameterizableViewController controller;
		for(String url : jspMapping.keySet()){
			controller = new ParameterizableViewController();
			controller.setViewName(jspMapping.get(url));
			jspViewBeans.put(url, controller);
		}
		mapping.setUrlMap(jspViewBeans);
		return mapping;
	}
	
	
	@Bean JspMappingConfig jspMapping(){
		JspMappingConfig config = new JspMappingConfig();
		//config.mapJspToUri("/centre/admin", "views/adminHome");
		config.mapJspToUri("/centre/admin/product", "product");
		config.mapJspToUri("/centre/admin/package", "package");
		config.mapJspToUri("/centre/admin/tutor", "tutor");
		config.mapJspToUri("/centre/admin/enroll", "enroll");
		config.mapJspToUri("/centre/admin/appointments", "appointments");
		config.mapJspToUri("/centre/admin/reports", "reports");
		config.mapJspToUri("/centre/admin/tutorSchd", "tutorSchd");
		config.mapJspToUri("/centre/admin/appointmentView", "appointmentView");

		return config;
	}
	
	@Bean
	public SimpleControllerHandlerAdapter viewControllerHandlerAdapter(){
		return new SimpleControllerHandlerAdapter();
	}
	
	
	
	@Bean
	public ObjectMapper jacksonObjectMapper(){
		ObjectMapper om = new ObjectMapper();
		JaxbAnnotationIntrospector jai = new JaxbAnnotationIntrospector();
		om.setDeserializationConfig(om.getDeserializationConfig().withAnnotationIntrospector(jai));
		om.setSerializationConfig(om.getSerializationConfig().withAnnotationIntrospector(jai)
				.withDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")));
		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		om.setSerializationInclusion(Inclusion.NON_NULL);
		return om;
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public MappingJacksonHttpMessageConverter jacksonConverter(){
		MappingJacksonHttpMessageConverter jaxConverter = new AppJacksonHttpMessageConverter();
		jaxConverter.setObjectMapper(jacksonObjectMapper());
		return jaxConverter;
	}
	
	@Bean
	public RequestMappingHandlerAdapter adapter(){
		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
		adapter.setContentNegotiationManager(cnManager().getObject());
		adapter.setOrder(1);
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(jacksonConverter());
		adapter.setMessageConverters(converters);
		return adapter;
		
	}
	
	protected static class JspMappingConfig{
		private Map<String, String> map = new HashMap<>();
		Map<String, String> getConfig(){
			return map;
		}
		void mapJspToUri( String url, String pathToJsp){
			map.put(url, pathToJsp);
		}
	}
}

