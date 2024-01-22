package com.metlushko.book.config;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    private static final int ENTRIES = 10;
    private static final String PRE_CONFIGURED = "bookCache";

    @Bean
    public CacheManager cacheManager() {

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache(PRE_CONFIGURED,
                        CacheConfigurationBuilder
                                .newCacheConfigurationBuilder(
                                        Long.class,
                                        String.class,
                                        ResourcePoolsBuilder.heap(ENTRIES)))
                .build();
        cacheManager.init();
        return cacheManager;
    }

}



