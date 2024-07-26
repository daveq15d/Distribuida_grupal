package com.distribuida.appgateway.config;


import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {


    @Bean
    public CaffeineCacheManager cacheManager(){
        return new CaffeineCacheManager();
    }
}
