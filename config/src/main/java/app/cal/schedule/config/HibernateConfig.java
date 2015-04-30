package app.cal.schedule.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.cal.schedule.business.entity.BaseEntity;


@Configuration
@EnableTransactionManagement
//@ComponentScan({ "com.websystique.springmvc.configuration" })
public class HibernateConfig {
	
    @Autowired
    private Environment environment;

    @Autowired
    private DataSourceConfig dataSourceConfig;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceConfig.dataSource());
        sessionFactory.setPackagesToScan(new String[] { BaseEntity.class.getPackage().getName() });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
    
	@Bean
    public HibernateTransactionManager transactionManager() {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory().getObject());
       return txManager;
    }

}
