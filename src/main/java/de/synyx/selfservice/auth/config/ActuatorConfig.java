package de.synyx.selfservice.auth.config;

import de.synyx.selfservice.auth.security.SecurityOrder;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@Order(SecurityOrder.ACTUATOR_ORDER)
public class ActuatorConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception { // NOSONAR

        http.httpBasic()
            .and()
            .logout()
            .deleteCookies("JSESSIONID")
            .and()
            .requestMatchers()
            .antMatchers("/jolokia")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }
}