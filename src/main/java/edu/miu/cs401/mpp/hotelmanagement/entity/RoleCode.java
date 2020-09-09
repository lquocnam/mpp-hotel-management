package edu.miu.cs401.mpp.hotelmanagement.entity;

import java.util.Arrays;
import java.util.Objects;

public enum RoleCode {
    ADMIN("Admin"),
    STAFF("Staff");
    private String name;

    RoleCode(String name) {
        this.name = name;
    }

    public static RoleCode get(String code) {
        return Arrays.stream(RoleCode.values()).filter(rc -> Objects.equals(rc.name, code)).findAny().orElse(null);
    }

    public String getName() {
        return name;
    }
}
