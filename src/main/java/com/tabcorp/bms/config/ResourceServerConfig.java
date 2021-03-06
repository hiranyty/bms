package com.tabcorp.bms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableResourceServer
@Configuration
public class ResourceServerConfig extends  ResourceServerConfigurerAdapter {
		
	  @Override
	  public void configure(HttpSecurity http) throws Exception {
		  
		  http
		  .csrf().disable()
		  .headers().frameOptions().disable()
		  .and()
		  .requestMatchers()
          .antMatchers("/v1/**","/h2/**")
          .and()
          .authorizeRequests() 
          .antMatchers("/h2/**").permitAll()
          .antMatchers("/v1/**")
          .authenticated()
          .and()
          .formLogin()
          .permitAll();		 
	    }
}
