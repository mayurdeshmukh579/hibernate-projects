package com.maytech.lms.initializer;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class LmsConfig {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver  viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setPackagesToScan("com.maytech.lms.entitty");
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		
		
		return sessionFactoryBean;
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	@Bean
	public DataSource getDataSource() throws PropertyVetoException {
		
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("Mayur@123");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/lmsportal");
//		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Mayur@123");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lmsportal");
		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		
		
		return comboPooledDataSource;
	}
}
