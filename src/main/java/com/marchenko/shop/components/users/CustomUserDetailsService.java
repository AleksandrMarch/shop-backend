package com.marchenko.shop.components.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.DataSource;

public interface CustomUserDetailsService extends UserDetailsService {

    UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException;
    public void setDataSource(DataSource dataSource);

}
