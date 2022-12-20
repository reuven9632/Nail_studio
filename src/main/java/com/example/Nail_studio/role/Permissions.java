package com.example.Nail_studio.role;

public enum Permissions {

    ORDER_CREATE("order:create"),
    ORDER_DROP("order:drop"),
    OPTION_EXTRA("option:extra"),
    OPTION_HIDE("option:hide"),
    DIARY_READ("diary:read"),
    DIARY_WRITE("diary:write");



    private final String permission;



    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
