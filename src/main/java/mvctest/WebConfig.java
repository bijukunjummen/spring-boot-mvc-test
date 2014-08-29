package mvctest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hotels/partialsList").setViewName("hotels/partialsList::content");
		registry.addViewController("/hotels/partialsCreate").setViewName("hotels/partialsCreate::content");
		registry.addViewController("/hotels/partialsEdit").setViewName("hotels/partialsEdit::content");
		registry.addViewController("/mappings/partialsMappings").setViewName("mappings/partialsMappings::content");
	}

}