package mvctest.config;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Profile("cloud")
@Configuration
public class PostgresCloudConfig extends AbstractCloudConfig {

	@Bean
	public DataSource dataSource() {
		return connectionFactory().dataSource();
	}
}


