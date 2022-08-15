package app.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
	public class  webconfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry cors) {

	        // set up cors mapping
	        cors.addMapping("/api/**").allowedOrigins("*");
	    }
	}












