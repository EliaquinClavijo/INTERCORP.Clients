package com.intercorp.clients.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenApiConfiguration {

    @Autowired
    private Environment env;

    private final String moduleName;
    private final String moduleDescription;
    private final String apiVersion;

    public OpenApiConfiguration(
            @Value("INTERCORP.Clients") String moduleName,
            @Value("Este microservicio se encarga de mostrar informacion asi como estadisticas de los clientes \n"
                    + " -----------  ------------  \n   ----------------  ------------") String moduleDescription,
            @Value("v1.0") String apiVersion) {
        this.moduleName = moduleName;
        this.apiVersion = apiVersion;
        this.moduleDescription = moduleDescription;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "Authorization";
        final String apiTitle = String.format("%s API", StringUtils.capitalize(moduleName));
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .description("Standard Authorization header using the Bearer scheme. Example: \"bearer {token}\"")
                                                .in(In.HEADER)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .addServersItem(new Server().url("http://localhost:" + env.getProperty("server.port")))
                .info(new Info().title(apiTitle).version(apiVersion).description(moduleDescription));
    }
}
