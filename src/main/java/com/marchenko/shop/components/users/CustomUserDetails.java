package com.marchenko.shop.components.users;

import org.springframework.security.core.userdetails.UserDetails;

interface CustomUserDetails extends UserDetails {

    public Long getId();
    public void setId(Long id);

}
