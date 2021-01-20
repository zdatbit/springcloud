package com.zdatbit.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement                            //事务管理
@PropertySource("classpath:/mysql.properties")          //导入外部配置
@Configuration                                          //这是一个配置类
@ComponentScan("com.zdatbit.tx")                        //扫描的基类
public class TxConfig {

    @Value("${mysql.userName}")
    public String userName;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driver}")
    private String driver;

    @Bean
    public DataSource dataSource() throws Exception{
        ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");

        dataSource.setUser(userName);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception{
        //这里直接调用不会再创建一个datasource
        return new JdbcTemplate(dataSource());
    }

    //事务管理
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception{
        return new DataSourceTransactionManager(dataSource());
    }
}
