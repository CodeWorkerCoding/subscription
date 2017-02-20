//package com.nchu.weixin.subscription.config.data;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * 数据源配置
// * Created by fujianjian on 2017/2/20.
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
//    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "externalDataSource")
//    @Qualifier("externalDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.external")
//    public DataSource externalDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//}
