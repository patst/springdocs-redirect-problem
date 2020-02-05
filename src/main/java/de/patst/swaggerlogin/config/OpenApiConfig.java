package de.patst.swaggerlogin.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
    name = "oauth2",
    type = SecuritySchemeType.OAUTH2,
    bearerFormat = "jwt",
    in = SecuritySchemeIn.HEADER,
    flows = @OAuthFlows(
        authorizationCode = @OAuthFlow(
            authorizationUrl = "${spring.security.oauth2.resourceserver.jwt.authorization-url}",
            tokenUrl = "${spring.security.oauth2.resourceserver.jwt.token-url}")
    ))
public class OpenApiConfig {


}
