package fr.formation.tetris_dao.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({"fr.formation.tetrimino_model","fr.formation.tetris_dao.tetrimino.dao"})
@PropertySource({ "classpath:data-source.properties" })
@EnableAspectJAutoProxy
public class ConfigSpring {
	@Autowired
	private Environment env;
	
	
	@Bean("dataSource")
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("sql.driver"));
		dataSource.setUrl(env.getProperty("sql.url"));
		dataSource.setUsername(env.getProperty("sql.username"));
		dataSource.setPassword(env.getProperty("sql.password"));
		dataSource.setMaxTotal(env.getProperty("sql.maxTotal", Integer.class));
		
		return dataSource;
	}
	
	
	@Bean
	public Connection getConn() {
		try {
			return this.dataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
