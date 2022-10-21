package com.example.Nail_studio.role;

import com.google.common.collect.Sets;

import java.util.Set;

public enum Role {
    USER(Sets.newHashSet(Permissions.DIARY_READ,Permissions.ORDER_CREATE,Permissions.ORDER_DROP)),
    CLIENT(Sets.newHashSet(Permissions.DIARY_READ, Permissions.ORDER_CREATE, Permissions.ORDER_DROP)),
    SPECIALIST(Sets.newHashSet(Permissions.DIARY_READ, Permissions.DIARY_WRITE, Permissions.ORDER_CREATE, Permissions.ORDER_DROP)),
    ADMINISTRATOR(Sets.newHashSet(Permissions.DIARY_READ, Permissions.DIARY_WRITE, Permissions.ORDER_CREATE, Permissions.ORDER_DROP, Permissions.OPTION_EXTRA, Permissions.OPTION_HIDE));

    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
