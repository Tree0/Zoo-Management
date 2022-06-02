package com.zoorb.zoomanagement;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable().authorizeRequests()
        .mvcMatchers("/").permitAll()
        .mvcMatchers("/viewA").permitAll()
        .mvcMatchers("/Animalshow").permitAll()
        .mvcMatchers("/showall").permitAll()
        .mvcMatchers("/animal_add.html").access("hasRole('ADMIN')")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login")
        .defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
        .and().
        headers().frameOptions().disable()
        .and().
        httpBasic(); 
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("raajit11").password("123").roles("STUDENT")
                .and()
                .withUser("user2").password("456").roles("STUDENT")
                .and()
                .withUser("admin").password("admin123").roles("ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
