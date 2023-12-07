package ejpg.ekan.poc.boot;

import java.util.Collections;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "ejpg.ekan.poc.data.config", 
		"ejpg.ekan.poc.web.config" })
public class Application {

	public static void main(String[] args) {
		SpringApplication boot = new SpringApplication(Application.class);
		boot.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
		boot.run(args);
	}

	@Bean
	public ErrorController error() {
		return () -> "/error";
	}
	
	@Bean
	@SuppressWarnings("unchecked")
	public ServletRegistrationBean h2ServletRegistrationBean() {
		ServletRegistrationBean registration = 
				new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/database/console/*");
		return registration;
	}

}
