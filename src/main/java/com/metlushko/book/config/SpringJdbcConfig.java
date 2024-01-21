package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringJdbcConfig {

    private final Environment env;
    private static final String KEY = "hibernate.driver_class";
    private static final String URL = "hibernate.connection.url";
    private static final String USERNAME = "hibernate.connection.username";
    private static final String PASSWORD = "hibernate.connection.password";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty(KEY));
        dataSource.setUrl(env.getRequiredProperty(URL));
        dataSource.setUsername(env.getRequiredProperty(USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PASSWORD));

        return dataSource;
    }
    @Bean
    public GeneratedKeyHolder generatedKeyHolder(){
        return new GeneratedKeyHolder();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public BeanPropertyRowMapper<?> beanPropertyRowMapper(){
        return new BeanPropertyRowMapper<>(Book.class);
    }
}
