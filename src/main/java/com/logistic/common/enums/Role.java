package com.logistic.common.enums;

public enum Role {
    ADMIN,
    USER;

    public static Role from(String value) {
        try {
            return Role.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid role: " + value);
        }
    }
}