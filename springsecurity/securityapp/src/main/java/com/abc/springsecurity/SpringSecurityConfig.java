package com.abc.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {

		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(User.withUsername("rohit")
				.password(passwordEncoder.encode("rohit123"))
				.roles("USER").build());

		manager.createUser(
				User.withUsername("wipro")
				.password(passwordEncoder.encode("wipro123"))
				.roles("ADMIN").build());

		return manager;

	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		    http.csrf(AbstractHttpConfigurer::disable)
		      .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
		              authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
		                      .requestMatchers("/admin/**").hasAnyRole("ADMIN")
		                      .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		                      .requestMatchers("/login/**").permitAll()
		                      .anyRequest().authenticated())
		      .httpBasic(Customizer.withDefaults())
		      .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	 return http.build();
	}


	@Bean
	static BCryptPasswordEncoder passwordEncoder() {
		// return NoOpPasswordEncoder.getInstance(); //to store the passwords as plain text
		return new BCryptPasswordEncoder();
	}

}
