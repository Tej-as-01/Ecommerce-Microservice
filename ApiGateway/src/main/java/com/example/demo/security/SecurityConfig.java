package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;

import org.springframework.http.HttpMethod;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	//Restricts POST,PUT,DELETE operations on productsmicroservice to users with ADMIN role
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.csrf().disable()
				.authorizeExchange(ex -> ex.pathMatchers(HttpMethod.POST, "/productsmicroservice/products/**")
						.hasRole("ADMIN").pathMatchers(HttpMethod.PUT, "/productsmicroservice/products/**")
						.hasRole("ADMIN").pathMatchers(HttpMethod.DELETE, "/productsmicroservice/products/**")
						.hasRole("ADMIN").anyExchange().authenticated())
				.httpBasic();
		return http.build();
	}

	//Creates two users one with ADMIN role and the other with USER role
	@Bean
	public ReactiveUserDetailsService userDetailsService() {
		var admin = User.withDefaultPasswordEncoder().username("Admin").password("admin").roles("ADMIN").build();

		var user = User.withDefaultPasswordEncoder().username("Ramesh").password("user").roles("USER").build();

		return new MapReactiveUserDetailsService(admin, user);

	}
}
