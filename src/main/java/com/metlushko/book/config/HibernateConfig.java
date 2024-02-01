package com.metlushko.book.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.metlushko.book")
public class HibernateConfig {

    private final Environment env;

    private final DataSource dataSource;

    private static final String DIALECT = "hibernate.dialect";
    private static final String SHOW_SQL = "hibernate.show_sql";
    private static final String SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
    private static final String REGION_FACTORY_CLASS = "hibernate.cache.region.factory_class";

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setPackagesToScan("com.metlushko.book");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.setDataSource(dataSource);

        return localSessionFactoryBean;

    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.put(DIALECT, env.getRequiredProperty(DIALECT));
        properties.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
        properties.put(REGION_FACTORY_CLASS, env.getRequiredProperty(REGION_FACTORY_CLASS));
        properties.put(SECOND_LEVEL_CACHE, env.getRequiredProperty(SECOND_LEVEL_CACHE));


        return properties;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {

        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());

        return hibernateTransactionManager;

    }

}
