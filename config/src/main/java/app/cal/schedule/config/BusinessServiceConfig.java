package app.cal.schedule.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.cal.schedule.business.centre.AppointmentScheduleService;
import app.cal.schedule.business.centre.AppointmentScheduleServiceImpl;
import app.cal.schedule.business.centre.ClientEnrollmentService;
import app.cal.schedule.business.centre.ClientEnrollmentServiceImpl;
import app.cal.schedule.business.centre.ClientInfoService;
import app.cal.schedule.business.centre.ClientInfoServiceImpl;
import app.cal.schedule.business.centre.ClientSvcPkg;
import app.cal.schedule.business.centre.ClientSvcPkgImpl;
import app.cal.schedule.business.centre.LocationWorkHours;
import app.cal.schedule.business.centre.LocationWorkHoursImpl;
import app.cal.schedule.business.centre.PackageServiceImpl;
import app.cal.schedule.business.centre.ProductServiceImpl;
import app.cal.schedule.business.centre.TutorService;
import app.cal.schedule.business.centre.TutorServiceImpl;
import app.cal.schedule.business.corporate.CorporateInfoService;
import app.cal.schedule.business.corporate.CorporateInfoServiceImpl;
import app.cal.schedule.business.dao.jdbc.ClientSvcPkgReadDao;

@Configuration
public class BusinessServiceConfig {

	@Autowired
	CommandHandlerConfig commandHandlerConfig;
	
	@Autowired
	ReadServicesConfig readServicesConfig;
	
	
	@Bean
	public ProductServiceImpl productService(){		
		return new ProductServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.productReadDao());
	}
	
	@Bean
	public PackageServiceImpl packageService(){		
		return new PackageServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.packageReadDao()
				);
	}
	
	@Bean
	public CorporateInfoService corporateInfoService(){
		return new CorporateInfoServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory() );
	}

	@Bean
	public TutorService tutorService(){
		return new TutorServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.tutorReadDao());
	}
	
	@Bean
	public ClientInfoService clientInfoService(){
		return new ClientInfoServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.clientInfoReadDao());
	}
	
	@Bean
	public ClientEnrollmentService clientEnrollmentService(){
		return new ClientEnrollmentServiceImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.clientEnrollmentReadDao());
		
	}
	
	@Bean
	public LocationWorkHours locationWorkHours(){
		return new LocationWorkHoursImpl( commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.locWrkHrsDao());
	}
	
	
	@Bean
	public ClientSvcPkg clientSvcPkg(){
		return new ClientSvcPkgImpl(commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.clientSvcPkgReadDao());
	}
	
	@Bean
	public AppointmentScheduleService appointmentScheduleService(){
		return new AppointmentScheduleServiceImpl(commandHandlerConfig.commandHandlerFactory(),
				commandHandlerConfig.handlerContextFactory(),
				readServicesConfig.appointmentScheduleReadDao());
	}
}
