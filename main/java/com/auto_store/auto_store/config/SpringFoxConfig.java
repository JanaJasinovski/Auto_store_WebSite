package com.auto_store.auto_store.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Education Swagger Api")
                        .version("1.0.0")
                        .contact(
                                new Contact()
                                        .email("jantschick3@gmail.com")
                                        .name("Jana Jasinovski")
                        )
                );
    }
}
