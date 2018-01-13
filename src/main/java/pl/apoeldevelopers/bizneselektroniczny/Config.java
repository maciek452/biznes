package pl.apoeldevelopers.bizneselektroniczny;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Jakub Michałowski on 13.01.2018.
 * All rights reserved.
 */
@Configuration
@SpringBootApplication
public class Config {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mahout");
        dataSource.setUsername("user");
        dataSource.setPassword("Buterier123");


        return dataSource;
    }
}
