package com.sugarcanemillrepository.sugarcanemillrepositorycore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SugarcanemillrepositorycoreApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SugarcanemillrepositorycoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SugarcanemillrepositorycoreApplication.class, args);
	}
}
