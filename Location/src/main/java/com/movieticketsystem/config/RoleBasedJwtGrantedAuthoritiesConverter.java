package com.movieticketsystem.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class RoleBasedJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        
        // Extract and map roles from JWT token claims to authorities
        List<String> roles = jwt.getClaimAsStringList("cognito:groups");
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role)));
        
        return authorities;
    }
}
