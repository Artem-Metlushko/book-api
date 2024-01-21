package com.metlushko.book.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class LiquibaseConfig {

    private final Environment env;
    private final DataSource dataSource;
    private static final String PATH = "liquibase.changeLogFiles";

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setChangeLog(env.getRequiredProperty(PATH));
        liquibase.setDataSource(dataSource);
        

        return liquibase;
    }
}
