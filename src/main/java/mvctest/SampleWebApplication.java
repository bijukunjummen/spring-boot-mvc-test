package mvctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleWebApplication  extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(SampleWebApplication.class)
				.initializers(new SampleWebApplicationInitializer())
				.run(args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.initializers(new SampleWebApplicationInitializer());
		application.sources(SampleWebApplication.class);
		return application;
	}
}
