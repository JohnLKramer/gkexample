package com.example.gkexample.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.gkexample.entities")
class PersistenceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.gkexample")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("spring.datasource.gkexample.configuration")
    DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build()
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean()
        em.setDataSource(dataSource())
        String[] packages = ["com.example.gkexample"]
        em.setPackagesToScan(packages)
        em.setPersistenceUnitName("gkexample")
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter()
        em.setJpaVendorAdapter(vendorAdapter)
        em.setJpaProperties(hibernateProperties())
        return em
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties()
        properties.put("hibernate.dialect", "com.example.gkexample.sqlite.SQLiteDialect")
        properties.put("hibernate.show_sql", "true")
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy")
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy")
        return properties
    }

    @Bean
    JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager()
        transactionManager.setEntityManagerFactory(emf)
        return transactionManager
    }

    @Bean
    @Qualifier("namedJdbcTemplate")
    NamedParameterJdbcTemplate namedJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
