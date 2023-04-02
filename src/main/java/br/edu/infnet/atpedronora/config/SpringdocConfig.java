package br.edu.infnet.atpedronora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    @Bean
    OpenAPI baseOpenApi() {
        return new OpenAPI().info(new Info()
        .title("Lista de Contatos API")
        .version("1.0.0")
        .description("Documentação da API para realização das operações de criação, atualização, remoção e consulta da Lista de Contatos API"));
    }
}
