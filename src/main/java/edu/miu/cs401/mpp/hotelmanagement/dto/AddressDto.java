package edu.miu.cs401.mpp.hotelmanagement.dto;

public class AddressDto {
    private String street;
    private String city;
    private String state;
    private String zip;

    public String getAddress() {
        return String.format(" %s, %s, %s %s", street, city, state, zip);
    }

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public AddressDto setZip(String zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
