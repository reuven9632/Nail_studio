package com.example.Nail_studio.role;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.Nail_studio.role.Permissions.*;

public enum Role {
    USER(Sets.newHashSet(DIARY_READ, ORDER_CREATE, ORDER_DROP)),
    CLIENT(Sets.newHashSet(DIARY_READ, ORDER_CREATE, ORDER_DROP)),
    SPECIALIST(Sets.newHashSet(DIARY_READ, DIARY_WRITE, ORDER_CREATE, ORDER_DROP)),
    ADMINISTRATOR(Sets.newHashSet(DIARY_READ, DIARY_WRITE, ORDER_CREATE, ORDER_DROP, OPTION_EXTRA, OPTION_HIDE));


    private final Set<Permissions> permissions;


    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }


    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
