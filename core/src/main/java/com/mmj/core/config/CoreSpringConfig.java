package com.mmj.core.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mmj.core.dao.CoreDaoPkg;
import com.mmj.core.serviceImpl.CoreServicePkg;

@Configuration
@ComponentScan(basePackageClasses = { CoreServicePkg.class, CoreDaoPkg.class })
@EnableTransactionManagement
@MapperScan(basePackages = {"com.mmj.core.mapper"}, sqlSessionFactoryRef = "coreSqlSessionFactoryBean")
public class CoreSpringConfig {
    @Bean
    public SqlSessionFactory coreSqlSessionFactoryBean(@Autowired final DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.mmj.core.model");
        return bean.getObject();
    }
}
