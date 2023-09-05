package com.movieticketsystem.location;

import com.movieticketsystem.config.RoleBasedJwtGrantedAuthoritiesConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication
// @EnableDiscoveryClient
public class LocationApplication {

//	@Value(value = "${aws.cognito.jwk}")
//	private String cognitoJWKS;

	public static void main(String[] args) throws Exception{
		SpringApplication.run(LocationApplication.class, args);

		
	}


//	@Bean
////	@Order(Ordered.HIGHEST_PRECEDENCE)
//	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET,"/city/**").hasAnyRole("Admin","Users")
//						.requestMatchers("/city/**").hasRole("Admin")
//
//				)
//				.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
//						.jwt(jwt -> jwt.decoder(jwtDecoder())
//								.jwtAuthenticationConverter(jwtAuthenticationConverter())));
//
//		return http.build();
//	}
//
//	@Bean
//	public Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
//		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//		converter.setJwtGrantedAuthoritiesConverter(new RoleBasedJwtGrantedAuthoritiesConverter());
//		return converter;
//	}
//
//	@Bean
//	public JwtDecoder jwtDecoder() {
//		return NimbusJwtDecoder.withJwkSetUri(cognitoJWKS).build();
//	}

}
