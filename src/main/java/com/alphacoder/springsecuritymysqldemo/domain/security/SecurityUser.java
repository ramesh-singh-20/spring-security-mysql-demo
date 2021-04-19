package com.alphacoder.springsecuritymysqldemo.domain.security;

import com.alphacoder.springsecuritymysqldemo.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {
    private final UserEntity userEntity;

    public SecurityUser(UserEntity userEntity){
        this.userEntity= userEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()-> "read");
    }

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
