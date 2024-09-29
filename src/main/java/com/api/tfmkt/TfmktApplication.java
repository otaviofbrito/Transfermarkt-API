package com.api.tfmkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching
public class TfmktApplication {

    public static void main(String[] args) {
        SpringApplication.run(TfmktApplication.class, args);
    }

}
