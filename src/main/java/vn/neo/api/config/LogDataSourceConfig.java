package vn.neo.api.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = LogDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "logSqlSessionFactory")
public class LogDataSourceConfig {
	
	static final String PACKAGE = "vn.neo.api.mapper.log";
    static final String MAPPER_LOCATION = "classpath:vn/neo/api/mapper/log/*.xml";
    
    @Bean(name="logDataSource")
    @ConfigurationProperties("spring.datasource-log")
    public HikariDataSource logDataSource() {
        return (HikariDataSource) DataSourceBuilder.create().build();
    }

    @Bean(name = "logTransactionManager")
    public DataSourceTransactionManager logTransactionManager() {
        return new DataSourceTransactionManager(logDataSource());
    }

    @Bean(name = "logSqlSessionFactory")
    public SqlSessionFactory logSqlSessionFactory(@Qualifier("logDataSource") DataSource logDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(logDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}