package app.cal.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.cal.schedule.business.dao.hibernate.ClientEnrollmentDao;
import app.cal.schedule.business.dao.hibernate.ClientGrpDao;
import app.cal.schedule.business.dao.hibernate.ClientScheduleInfoDao;
import app.cal.schedule.business.dao.hibernate.ClientSvcPkgDao;
import app.cal.schedule.business.dao.hibernate.CorporateInfoDao;
import app.cal.schedule.business.dao.hibernate.HibernateClientEnrollmentImpl;
import app.cal.schedule.business.dao.hibernate.HibernateClientGrpDaoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateClientScheduleInfoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateClientSvcPkgInfoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateCorpDaoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateLocationWorkHoursImpl;
import app.cal.schedule.business.dao.hibernate.HibernatePackageDaoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateProductDaoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateTutorDaoImpl;
import app.cal.schedule.business.dao.hibernate.HibernateTutorScheduleDaoImpl;
import app.cal.schedule.business.dao.hibernate.LocationWrkHrsDao;
import app.cal.schedule.business.dao.hibernate.PackageDao;
import app.cal.schedule.business.dao.hibernate.ProductDao;
import app.cal.schedule.business.dao.hibernate.TutorDao;
import app.cal.schedule.business.dao.hibernate.TutorScheduleDao;

@Configuration
public class DaoConfig {

	@Autowired
	private HibernateConfig hibernateConfig;
	
/*	private Environment environment;
	
	private DataSourceConfig dataSourceConfig;*/
	
	@Bean
	public ProductDao productDao(){
		return new HibernateProductDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public PackageDao packageDao(){
		return new HibernatePackageDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public CorporateInfoDao corpInfoDao(){
		return new HibernateCorpDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public TutorDao tutorDao(){
		return new HibernateTutorDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public ClientGrpDao clientInfoDao(){
		return new HibernateClientGrpDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public ClientEnrollmentDao clientEnrollmentDao(){
		return new HibernateClientEnrollmentImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public LocationWrkHrsDao locationWorkHrsDao(){
		return new HibernateLocationWorkHoursImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public TutorScheduleDao tutorScheduleDao(){
		return new HibernateTutorScheduleDaoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public ClientSvcPkgDao clientSvcPkgDao(){
		return new HibernateClientSvcPkgInfoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
	
	@Bean
	public ClientScheduleInfoDao clientScheduleInfoDao(){
		return new HibernateClientScheduleInfoImpl(hibernateConfig.sessionFactory().getObject(), null);
	}
}
