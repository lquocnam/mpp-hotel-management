package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.entity.Role;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoleCode;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Role, RoleCode> {
    @Override
    public RoleCode toDto(Role role) {
        return role == null ? null : role.getCode();
    }

    @Override
    public Role fromDto(RoleCode roleCode) {
        return roleCode == null ? null : new Role().setCode(roleCode).setName(roleCode.getName());
    }

    @Override
    public Role fromDto(RoleCode roleCode, Role role) {
        return roleCode == null ? null : role.setCode(roleCode).setName(roleCode.getName());
    }
}
