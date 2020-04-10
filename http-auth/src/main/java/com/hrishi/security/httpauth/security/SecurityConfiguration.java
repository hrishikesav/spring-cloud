package com.hrishi.security.httpauth.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity security) throws Exception {
		security
		.antMatcher("/**")  
        .authorizeRequests()  
        .antMatchers("/", "/login**").permitAll()  
        .anyRequest().authenticated()  
        .and()  
        .oauth2Login(); 
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password("{noop}pass")
		.roles("USER");
	}
}
