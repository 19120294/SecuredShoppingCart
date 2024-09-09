package com.KLBproject.KLB_project.security.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    //Name, ver, des, sv for API Doc
    @Bean
    public OpenAPI customOpenAPI    (@Value("${open.api.title}") String title,
                                    @Value("${open.api.version}") String version,
                                    @Value("${open.api.description}") String description,
                                    @Value("${open.api.serverUrl}") String ServerUrl,                                    @Value("${open.api.serverUrl}") String serverUrl,
                                    @Value("${open.api.serverName}") String serverName)
        {
        return new OpenAPI().info(new Info().title(title)
                                .version(version)
                               .description(description)
                                .license(new License().name("API License")))
                              .servers(List.of(new Server().url(ServerUrl).description(serverName)));
    }


    //Grouped API
    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group("api-service-1")
                .packagesToScan("com.KLBproject.KLB_project.controller")
                .build();
    }
}