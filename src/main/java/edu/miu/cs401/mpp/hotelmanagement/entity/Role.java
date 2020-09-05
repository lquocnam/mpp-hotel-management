package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private String code;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getCode() {
        return code;
    }

    public Role setCode(String code) {
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

//    public Role setUsers(Set<User> users) {
//        this.users = users;
//        return this;
//    }
}
