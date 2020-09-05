package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.Role;
import java.time.LocalDate;
import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    private String encryptedPassword;
    private String fullname;
    private String gender;
    private LocalDate dateOfBirth;
    private String createdBy;
    private LocalDate createdAt;
    private String modifiedBy;
    private LocalDate modifiedAt;
    private Long phoneNumber;
    private Set<Role> roles;

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public UserDto setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public UserDto setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public UserDto setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public UserDto setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public UserDto setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public UserDto setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public UserDto setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public UserDto setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserDto setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedAt=" + modifiedAt +
                ", phoneNumber=" + phoneNumber +
                ", roles=" + roles +
                '}';
    }
}
