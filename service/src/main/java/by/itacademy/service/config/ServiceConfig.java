package by.itacademy.service.config;

import by.itacademy.database.config.DBConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("by.itacademy.service")
@EnableTransactionManagement
@Import(DBConfig.class)
public class ServiceConfig {
}
