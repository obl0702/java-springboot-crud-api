package asia.fourtitude.productrestapi.config;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        final String[] packagesToScan = {"asia.fourtitude.productrestapi.controllers"};
        return GroupedOpenApi
                .builder()
                .group("Product API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/api/products/**")
                .addOpenApiCustomiser(statusApiCostumizer())
                .build();
    }

    private OpenApiCustomiser statusApiCostumizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("OpenAPI for Products")
                        .description("This is a sample Spring Boot RESTful service using OpenAPI")
                        .version("3.0.0")
                        .contact(new Contact()
                                .name("Ong Boon Loong")
                                .url("https://github.com/obl0702")
                                .email("obl0702@gmail.com")));
    }
}
