package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.RoleCode;

public class RoleDto {
    private RoleCode code;
    private String name;

    public RoleCode getCode() {
        return code;
    }

    public RoleDto setCode(RoleCode code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDto setName(String name) {
        this.name = name;
        return this;
    }
}
