package ru.spaceouter.infoscan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author danil
 * @date 20.04.19
 */
@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(basePackages = "ru.spaceouter.infoscan.model")
public class JdbcConfiguration {

}
