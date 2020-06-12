package com.example.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class ConfiguracionSeguridad  extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	private  ImplementacionServiceDetail detalleUsuario;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/seguro/").hasAnyRole("Admin").and().formLogin().
		loginPage("/user/login").loginProcessingUrl("/envio").usernameParameter("usuario").passwordParameter("clave").
		defaultSuccessUrl("/user/seguro/permiso").and().logout().logoutUrl("/app-logout")./*logoutSuccessUrl("/user/login").*/and(). 
		exceptionHandling().accessDeniedPage("/user/error");
	}
	
	
	@Autowired
protected void  configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
	
	BCryptPasswordEncoder e = new BCryptPasswordEncoder();
	auth.userDetailsService(detalleUsuario).passwordEncoder(e);
}
}
