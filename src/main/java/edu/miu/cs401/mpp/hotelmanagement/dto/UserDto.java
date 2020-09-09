package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.Gender;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoleCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    private Gender gender;
    private String name;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private AddressDto address;

    private Set<RoleCode> roles;

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public UserDto setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public UserDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public Set<RoleCode> getRoles() {
        return roles;
    }

    public UserDto setRoles(Set<RoleCode> roles) {
        this.roles = roles;
        return this;
    }
}
