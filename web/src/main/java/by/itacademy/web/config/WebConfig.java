package by.itacademy.web.config;

import by.itacademy.service.config.ServiceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("by.itacademy.web")
@Import(ServiceConfig.class)
public class WebConfig {
}
