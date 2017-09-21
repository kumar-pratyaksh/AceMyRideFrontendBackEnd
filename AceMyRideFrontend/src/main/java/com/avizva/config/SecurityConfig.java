package com.avizva.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		System.out.println("INSIDE CONFIGURE GLOBAL");
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email,password,enabled from user where email=?")
				.authoritiesByUsernameQuery("select email,role from user where email=?");

		// auth.inMemoryAuthentication().withUser("Raju").password("1234").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll()
				.and()
				.formLogin().loginPage("/loginAdmin").loginProcessingUrl("/perform_login")
				.usernameParameter("email").passwordParameter("password")
				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/").and().csrf().disable();
	}
//	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//  
//      http.authorizeRequests() .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
//        .and().formLogin().loginPage("/admlogin").defaultSuccessUrl("/adminPage")
//		.usernameParameter("email1").passwordParameter("password1")
//        .and().exceptionHandling().accessDeniedPage("/error").and().csrf();
//  
//    }
//	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().
//		antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')").
//		and().formLogin().  //login configuration
//                loginPage("/admlogin").
//                loginProcessingUrl("/perform_login").
//                usernameParameter("email1").
//                passwordParameter("password1").
//                defaultSuccessUrl("/home").	
//		and().logout().    //logout configuration
//		logoutUrl("/logout"). 
//				logoutSuccessUrl("/home").and().csrf().disable();
//	} 

}