package com.sevatec.tics.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
		"com.sevatec.tics.repo" })
public class Config {

	@Value("${app.datasource.url}")
	private String appDatasourceURL;

	@Value("${app.datasource.driverClassName}")
	private String appDatasourceDriverClassName;

	@Value("${app.datasource.username}")
	private String appDatasourceUsername;

	@Value("${app.datasource.password}")
	private String appDatasourcePassword;
	
	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName(appDatasourceDriverClassName)
				.url(appDatasourceURL).username(appDatasourceUsername).password(appDatasourcePassword).build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.sevatec.tics.domain")
				.persistenceUnit("defaultPersistenceUnit").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Value("${app.flyway.clean.before.migrate}")
	private Boolean cleanBeforeMigrate;

	@Bean
	Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setValidateOnMigrate(true);
		flyway.setDataSource(dataSource());
		flyway.setTable("SCHEMA_VERSION");

		if (cleanBeforeMigrate) {
			flyway.clean();
		}

		flyway.migrate();
		return flyway;
	}
}