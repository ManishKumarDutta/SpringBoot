package com.manish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/student/**").hasAnyAuthority(null)
		
	}
	
	public WebSecurityCustomizer webSecurityCustomizer() {
		
	}
}