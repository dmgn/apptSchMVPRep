package app.cal.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import app.cal.schedule.business.dao.jdbc.ClientSvcPkgReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcAppointmentScheduleReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcClientEnrollmentReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcClientInfoReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcClientSvcPkgReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcLocationWorkHoursReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcPackageReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcProductReadDao;
import app.cal.schedule.business.dao.jdbc.JdbcTutorReadDao;
import app.cal.schedule.business.dao.sp.StoredProcGetTimeSlotDetails;

@Configuration
public class ReadServicesConfig {

	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Bean
	public JdbcProductReadDao productReadDao(){
		return new JdbcProductReadDao(dataSourceConfig.dataSource());
	}
	
	@Bean
	public JdbcPackageReadDao packageReadDao(){
		return new JdbcPackageReadDao(dataSourceConfig.dataSource());
	}
	
	@Bean
	public JdbcTutorReadDao tutorReadDao(){
		return new JdbcTutorReadDao(dataSourceConfig.dataSource());
	}
	
	@Bean
	public JdbcClientInfoReadDao clientInfoReadDao(){
		return new JdbcClientInfoReadDao(dataSourceConfig.dataSource());
	}
	
	@Bean
	public JdbcClientEnrollmentReadDao clientEnrollmentReadDao(){
		return new JdbcClientEnrollmentReadDao( dataSourceConfig.dataSource() );
	}
	
	@Bean
	public JdbcLocationWorkHoursReadDao locWrkHrsDao(){
		return new JdbcLocationWorkHoursReadDao( dataSourceConfig.dataSource() );
	}
	
	@Bean
	public ClientSvcPkgReadDao clientSvcPkgReadDao(){
		return new JdbcClientSvcPkgReadDao(dataSourceConfig.dataSource());
	}
	
	@Bean
	public StoredProcGetTimeSlotDetails spGetTimeSlotDetails(){
		return new StoredProcGetTimeSlotDetails(new JdbcTemplate(dataSourceConfig.dataSource()));
	}
	
	@Bean
	public JdbcAppointmentScheduleReadDao appointmentScheduleReadDao(){
		return new JdbcAppointmentScheduleReadDao( spGetTimeSlotDetails(), dataSourceConfig.dataSource() );
	}
}
