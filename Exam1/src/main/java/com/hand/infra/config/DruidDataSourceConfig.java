package com.hand.infra.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 张晶锦
 */
@Configuration
public class DruidDataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

//	@Value("${spring.datasource.initialSize}")
//	private int initialSize;
//
//	@Value("${spring.datasource.minIdle}")
//	private int minIdle;
//
//	@Value("${spring.datasource.maxActive}")
//	private int maxActive;
//
//	@Value("${spring.datasource.maxWait}")
//	private int maxWait;
//
//	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
//	private int timeBetweenEvictionRunsMillis;
//
//	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
//	private int minEvictableIdleTimeMillis;
//
//	@Value("${spring.datasource.validationQuery}")
//	private String validationQuery;
//
//	@Value("${spring.datasource.testWhileIdle}")
//	private boolean testWhileIdle;
//
//	@Value("${spring.datasource.testOnBorrow}")
//	private boolean testOnBorrow;
//
//	@Value("${spring.datasource.testOnReturn}")
//	private boolean testOnReturn;
//
//	@Value("${spring.datasource.poolPreparedStatements}")
//	private boolean poolPreparedStatements;
//
//	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
//	private int maxPoolPreparedStatementPerConnectionSize;
//
//	@Value("${spring.datasource.filters}")
//	private String filters;
//
//	@Value("{spring.datasource.connectionProperties}")
//	private String connectionProperties;

	@Bean
	public DataSource dataSource(){
		DruidDataSource duridDataSource = new DruidDataSource();
		duridDataSource.setDriverClassName(driver);
		String dbName = "sakila";
		//duridDataSource.setUrl(url);
		duridDataSource.setUrl("jdbc:mysql://"+System.getenv("MYSQL_IP")+":3306/"+dbName+"?serverTimezone=UTC&useSSL=false");
		duridDataSource.setUsername(username);
		duridDataSource.setPassword(password);


		//configuration
//		duridDataSource.setInitialSize(initialSize);
//		duridDataSource.setMinIdle(minIdle);
//		duridDataSource.setMaxActive(maxActive);
//		duridDataSource.setMaxWait(maxWait);
//		duridDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//		duridDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//		duridDataSource.setValidationQuery(validationQuery);
//		duridDataSource.setTestWhileIdle(testWhileIdle);
//		duridDataSource.setTestOnBorrow(testOnBorrow);
//		duridDataSource.setTestOnReturn(testOnReturn);
//		duridDataSource.setPoolPreparedStatements(poolPreparedStatements);
//		duridDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//
//		try {
//			duridDataSource.setFilters(filters);
//		} catch (SQLException e) {
//			logger.error("druid configuration initialization filter", e);
//		}
//		duridDataSource.setConnectionProperties(connectionProperties);
		return duridDataSource;
	}

}
