package de.patst.swaggerlogin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${spring.security.oauth2.resourceserver.jwt.key-value}")
  private RSAPublicKey publicKey;

  @Bean
  JwtDecoder jwtDecoderByPublicKeyValue() {
    return NimbusJwtDecoder.withPublicKey(publicKey).build();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/actuator/**", "/swagger-ui/**", "/v3/api-docs/**", "/oauth/**").permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated()
        .and().oauth2ResourceServer().jwt().decoder(jwtDecoderByPublicKeyValue());
  }
}
