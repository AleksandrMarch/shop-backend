package com.marchenko.shop.components.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private CustomJdbcUserDetailsManager userDetailsManager;

    @Autowired
    public UserService(CustomJdbcUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    public void saveUser(User user) {
        userDetailsManager.createUser(user);
    }

}
