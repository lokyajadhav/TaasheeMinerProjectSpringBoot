package com.TaasheeTrainigAcademy.MinerProject.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final DaoUserDetailsService daoUserDetailsService;
	@Autowired
	private CustomSuccessHandler successController;
	@Autowired
	public SecurityConfig(PasswordEncoder passwordEncoder, DaoUserDetailsService daoUserDetailsService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.daoUserDetailsService = daoUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","index","/css/*").permitAll()
		//.antMatchers(HttpMethod.POST,"/**").hasAuthority(UserPermissions.WRITE.getPermission())
	    // .antMatchers(HttpMethod.GET,"/**").hasAuthority(UserPermissions.READ.getPermission())
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.successHandler(successController)
		.usernameParameter("userName")
		
		.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.permitAll();
		
		
		//.defaultSuccessUrl("/", true).permitAll()
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(daoUserDetailsService);
		return provider;
	}
}
