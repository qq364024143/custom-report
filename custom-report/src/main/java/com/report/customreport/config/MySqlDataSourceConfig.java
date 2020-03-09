package com.report.customreport.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages="com.report.customreport.**.dao.mysql")
public class MySqlDataSourceConfig {
	
	@Bean("mysqlDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.mysql")
	public DataSource druidDataSource(){
		return DataSourceBuilder.create().build();
	} 
	
	@Primary
	@Bean("mysqlSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource")DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/mysql/*.xml"));
        return bean.getObject();
	}
	
	@Bean
	@Primary
	public DataSourceTransactionManager dataSourceTransactionManager (@Qualifier("mysqlDataSource")DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	
	@Bean
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
}
