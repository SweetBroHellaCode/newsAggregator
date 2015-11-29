package io.zipcoder;

import io.zipcoder.controllers.NewsUpdater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsCrawlerApplication.class, args);


    }
}
