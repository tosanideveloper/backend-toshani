// package com.toshaniFintech.auth.config;

// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//                 .components(new Components()
//                         .addSecuritySchemes("bearerAuth",
//                                 new SecurityScheme()
//                                         .name("Authorization")
//                                         .type(SecurityScheme.Type.HTTP)
//                                         .scheme("bearer")
//                                         .bearerFormat("JWT")
//                         )
//                 );
//     }
// }

package com.toshaniFintech.auth.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                // ✅ ADD THIS (VERY IMPORTANT)
                .info(new Info()
                        .title("Auth Service API")
                        .version("1.0")
                        .description("Authentication APIs"))

                // ✅ ADD THIS (FIXES 127.0.0.1 ISSUE COMPLETELY)
                .servers(List.of(
                        new Server().url("https://testapi.toshani.in")
                ))

                // Existing security config
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }
}
