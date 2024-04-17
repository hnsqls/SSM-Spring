package com.ls.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 配置类代替xml文件
 * 1. 引入外部文件
 * 2. 扫包
 * 3. 注册第三方的类
 *      bean的详细配置
 *          bean name : @Value
 *          bean scope: @Scope
 *          bean 周期方法：@init  @destoty
 *          bean 之间的依赖：
 *                  直接用方法获得
 *                  参数获得
 */
@Configuration
@ComponentScan({"com.ls.dao","com.ls.service"})
@PropertySource("classpath:jdbc.properties")
public class MainConfiguration {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driverClassname;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    //注册数据源---->使用druid第三方提供的类
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassname);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return  druidDataSource;
    }
    //bean的详细使用 name,initMethod,destroyMethod,以及作用域Scope("singleton"or"prototype")
    /**bean之间的依赖  ------->jdbcTemplate--->datasource
     * 方式一： 如果需要注入的依赖，也是@Bean标签下的，可以直接使用方法引用
     * 方式二： 使用参数注入，就是将需要注入的依赖，以参数的形式传入被注入的bean。
     *          确保参数一定存在参数类型的bean
     *          如果有多个类型，可以直接使用需要注入的名
     */

    @Bean(name = "jdbcTemplate", initMethod = "",destroyMethod = "")
    @Scope("singleton")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //如果需要注入的依赖，也是@Bean标签下的，可以直接使用方法引用
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    //使用参数传值，就是将需要注入的依赖，以参数的形式传入被注入的bean。
    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
