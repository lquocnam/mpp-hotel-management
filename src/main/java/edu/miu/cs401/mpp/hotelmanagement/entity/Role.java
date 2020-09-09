package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @Enumerated(EnumType.STRING)
    private RoleCode code;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public RoleCode getCode() {
        return code;
    }

    public Role setCode(RoleCode code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
