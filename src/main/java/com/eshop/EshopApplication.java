package com.eshop;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EshopApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(EshopApplication.class);
	}
	
	
	@Bean
	public FilterRegistrationBean coFilterRegistrationBean() {
	 FilterRegistrationBean registrationBean =	new FilterRegistrationBean(new CROSFilter());
	 registrationBean.setName("CORS Filter");
	 registrationBean.addUrlPatterns("/*");
	 registrationBean.setOrder(1);
	 return registrationBean;
		
		
	}
}





