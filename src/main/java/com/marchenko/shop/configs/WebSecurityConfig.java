package com.marchenko.shop.configs;

import com.marchenko.shop.components.users.CustomJdbcDaoImpl;
import com.marchenko.shop.components.users.CustomJdbcUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                csrf().disable()
                .authorizeRequests()
                    .anyRequest()
                    .permitAll()
                .and()
                    .formLogin()
                    .loginPage("/logon")
                    .successHandler((var1, var2, var3) -> {var2.setStatus(200);})
                    .failureHandler((var1, var2, var3) -> {
                        var2.setStatus(500);
                    })
                .and()
                .httpBasic();

    }

    @Bean
    @Autowired
    public CustomJdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        CustomJdbcUserDetailsManager manager = new CustomJdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Bean
    @Autowired
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new CustomJdbcDaoImpl(dataSource);
    }

}
