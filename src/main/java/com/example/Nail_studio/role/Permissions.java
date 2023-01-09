package com.example.Nail_studio.role;

public enum Permissions {

    ORDER_CREATE("order:create"),
    ORDER_DROP("order:drop"),

    OPTION_EXTRA("option:extra"),
    OPTION_HIDE("option:hide"),

    DIARY_READ("diary:read"),
    DIARY_WRITE("diary:write"),

    SPECIALIST_ADD("specialist:add"),
    SPECIALIST_EDIT("specialist:edit"),
    SPECIALIST_DELL("specialist:delete"),

    DEPARTMENT_ADD("department:add"),
    DEPARTMENT_EDIT("department:edit"),
    DEPARTMENT_DELL("department:delete");



    private final String permission;



    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
