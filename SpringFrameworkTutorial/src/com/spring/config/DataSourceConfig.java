package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DataSourceConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSourceEmbedded() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

		EmbeddedDatabase embeddedDatabase = builder.setType(EmbeddedDatabaseType.HSQL).addScript("").addScript("")
				.build();

		return embeddedDatabase;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	    dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	    dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	    return dataSource;
	}
}
