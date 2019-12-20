package ca.sheridancollege.Database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	@Bean

	public NamedParameterJdbcTemplate namedParameterJdbcTemplate

	(DataSource dataSource) {

	return new NamedParameterJdbcTemplate(dataSource);

	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost/assignment1");
		datasource.setUsername("root");
		datasource.setPassword("root123");
		
		return datasource;
	}
	

}
