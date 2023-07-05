package com.example.orderManagment.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;
@OpenAPIDefinition(
        info = @Info(
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Ishaq",
                        email = "isaacrajab17@aliboucoding.com",
                        url = "https://github.com/IsaacRajab/order-management"
                ),
                description = "Order Management System",
                title = "Order Management System",
                version = "1.0",
                license = @License(
                        name = "Licence name"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),

        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey(){
        return new ApiKey("Authorization", AUTHORIZATION_HEADER, "header");
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Order Management System",
                "Order Management System Documentation",
                "1",
                "Terms of service",
                new Contact("Ishaq", "", "isaacrajab17@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(List.of(apiKey())) /*Enable authorization for APIs in Swagger UI*/
                .select()
                .apis(RequestHandlerSelectors.any())/*get all APIs in the project, you can use .basePackage to scan only APIs in specific package like (RequestHandlerSelectors.basePackage("com.edu.controller.customer"))*/
                .paths(PathSelectors.any())  // Expose all APIs, you can restrict like expose only  .paths(PathSelectors.ant("/posts/*"))
                .build();
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");


        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("JWT", authorizationScopes));
    }
}