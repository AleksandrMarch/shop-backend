package com.marchenko.shop.components.users;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "USER";
    }
}
