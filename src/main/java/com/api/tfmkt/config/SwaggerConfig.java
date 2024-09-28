package com.api.tfmkt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${app.version}")
    private String appVersion;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Transfermarkt Scraper API")
                        .version(appVersion)
                        .description("This API provides endpoints to access data scrapped from Transfermarkt website")
                        .contact(new Contact()
                                .name("Transfermarkt Scraper API")
                                .url("https://github.com/otaviofbrito/Transfermarkt-API")));
    }
}
