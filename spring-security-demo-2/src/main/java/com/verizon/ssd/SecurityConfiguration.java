package com.verizon.ssd;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//@PreAuthorize()
	@Override	
	public void configure(WebSecurity web) throws Exception {			
		web.ignoring().antMatchers("/css/**","/js/**","/images/**");	
	}

		@Override	
		protected void configure(HttpSecurity http) throws Exception {
			
			/*http.authorizeRequests()
			.antMatchers("/cave/**").hasAnyRole("ADMIN","CLERK");
			
			http.authorizeRequests()
			.antMatchers("/cave/**").hasRole("CLERK");
			
			http.authorizeRequests().anyRequest().authenticated();*/
			
			http.authorizeRequests()
			.antMatchers("/cave/**").authenticated();
			
			http.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login?err=true")
			.usernameParameter("unm")
			.passwordParameter("pwd");
		
			http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/");
		}
}
																		
