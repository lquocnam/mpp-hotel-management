package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class Guest extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dob;

    @Embedded
    private Address address;

    public Gender getGender() {
        return gender;
    }

    public Guest setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Guest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Guest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Guest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public Guest setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Guest setAddress(Address address) {
        this.address = address;
        return this;
    }
}
