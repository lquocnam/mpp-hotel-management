package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GuestDto {
    private Long id;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private AddressDto address;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Long getId() {
        return id;
    }

    public GuestDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public GuestDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GuestDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GuestDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GuestDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public GuestDto setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public GuestDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "GuestDto{" +
                "id=" + id +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                '}';
    }
}
