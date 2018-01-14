package pl.apoeldevelopers.bizneselektroniczny;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecoList;
import pl.apoeldevelopers.bizneselektroniczny.entities.Recommendation;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserRating;
import pl.apoeldevelopers.bizneselektroniczny.utilities.DatabaseManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Michałowski on 13.01.2018.
 * All rights reserved.
 */
@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/mahout");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/mahout");
        dataSource.setUsername("user1");
        dataSource.setPassword("Buterier123");


        return dataSource;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Bean
    public RecoList recommendationList(){
        RecoList recoList = new RecoList();
        Recommendation recommendation = new Recommendation(1717, "adidas Adi-Ease BB8471", 199.00f, "http://172.20.83.41/polbuty/1717-22-adidas-adi-ease-bb8471.html", "http://172.20.83.41/2268-home_default/adidas-adi-ease-bb8471.jpg");

        recoList.add(recommendation);
        recoList.add(recommendation);
        recoList.add(recommendation);
        recoList.add(recommendation);


        return recoList;
    }

    @Bean
    public DatabaseManager databaseManager(){ return new DatabaseManager();}


}
