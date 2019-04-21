package ru.spaceouter.infoscan.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author danil
 * @date 21.04.19
 */
@Configuration
@EnableCaching
public class SimpleCacheConfiguration {

    @Bean
    CacheManager cacheManager(){

        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(Arrays.asList(
                "authentications"
        ));

        return cacheManager;
    }

}
