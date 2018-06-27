package br.com.esndev.plants.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;

import br.com.esndev.plants.configuration.pojo.CorsFilter;
import br.com.esndev.plants.configuration.pojo.CustomBasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomBasicAuthenticationEntryPoint authEntryPoint;

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password(new BCryptPasswordEncoder().encode("secret1"))
				.roles("USER").and().withUser("user2").password(new BCryptPasswordEncoder().encode("secret2"))
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter(), SessionManagementFilter.class).httpBasic()
				.authenticationEntryPoint(authEntryPoint);
		http.csrf().disable().httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/plants/company/find").permitAll().antMatchers(HttpMethod.GET)
				.authenticated().antMatchers(HttpMethod.POST).authenticated().antMatchers(HttpMethod.PUT)
				.authenticated().antMatchers(HttpMethod.DELETE).authenticated();
		http.headers().frameOptions().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}
}
