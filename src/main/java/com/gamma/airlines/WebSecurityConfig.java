/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;


/**
 * Class WebSecurityConfig.
 * 
 * this class for used to configure the security the security is configured based on role base by
 * default access is promoted to anonymous user and use both annotation {@link Secured} and
 * {@link PreAuthorize} to restrict access to resource
 *
 * @author Mohamed Morsy
 * @version 1.0
 * @see Configuration
 * @see EnableWebSecurity
 * @see EnableGlobalMethodSecurity
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /** admin username. */
  private final String ADMIN_USERNAME = "admin";

  /** admin passwored encrypted. */
  private final String ADMIN_PASSWORED_ENCRYPTED =
      "$2a$10$RWkxJ8sAywRZ1UuFGKcpDeWDA9h0/dhZLAAFawn4fdLBrd4q.ei4y";

  /*
   * configure http access and authorization rules
   * 
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().permitAll().and().formLogin().loginPage(URLS.LOGIN)
        .failureUrl(URLS.LOGIN_ERROR).defaultSuccessUrl(URLS.Home).and().logout()
        .logoutSuccessUrl(URLS.LOGIN);
  }

  /**
   * Configure authentication rules to be from database and the password to be encrypted using
   * {@link BCryptPasswordEncoder}}
   *
   * @param dataSource data source
   * @param auth authentication builder
   * @param passwordEncoder password encoder
   * @throws Exception exception
   * 
   */
  @Autowired
  public void configureGlobal(DataSource dataSource, AuthenticationManagerBuilder auth,
      PasswordEncoder passwordEncoder) throws Exception {
    auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser(ADMIN_USERNAME)
        .password(ADMIN_PASSWORED_ENCRYPTED).roles(RolesProperties.ADMIN);
    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
  }

  /**
   * Password encoder.
   *
   * @return password encoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
