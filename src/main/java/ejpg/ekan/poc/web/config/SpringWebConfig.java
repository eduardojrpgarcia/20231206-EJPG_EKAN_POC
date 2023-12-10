package ejpg.ekan.poc.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { 
		"ejpg.ekan.poc.web.handler",
		"ejpg.ekan.poc.web.controller",
		"ejpg.ekan.poc.web.service" })
public class SpringWebConfig implements WebMvcConfigurer {
	
}
