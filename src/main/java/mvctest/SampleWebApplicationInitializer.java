package mvctest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;

public class SampleWebApplicationInitializer implements ApplicationContextInitializer<AnnotationConfigEmbeddedWebApplicationContext> {

	private static final Log logger = LogFactory.getLog(SampleWebApplicationInitializer.class);

	@Override
	public void initialize(AnnotationConfigEmbeddedWebApplicationContext applicationContext) {
		Cloud cloud = getCloud();
		ConfigurableEnvironment appEnvironment = applicationContext.getEnvironment();

		if (cloud!=null) {
			appEnvironment.addActiveProfile("cloud");
		}

		logger.info("Cloud profile active");
	}

	private Cloud getCloud() {
		try {
			CloudFactory cloudFactory = new CloudFactory();
			return cloudFactory.getCloud();
		} catch (CloudException ce) {
			return null;
		}
	}
}
