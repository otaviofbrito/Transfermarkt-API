package com.api.tfmkt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Value("${app.version}")
    private String appVersion;
    @Value("${app.host}")
    private String host;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Transfermarkt Scraper API")
                        .version(appVersion)
                        .description("This API provides endpoints to access data scraped from Transfermarkt website")
                        .contact(new Contact()
                                .name("Transfermarkt Scraper API")
                                .url("https://github.com/otaviofbrito/Transfermarkt-API")))
                .addServersItem(new Server().url(host));
    }
}
