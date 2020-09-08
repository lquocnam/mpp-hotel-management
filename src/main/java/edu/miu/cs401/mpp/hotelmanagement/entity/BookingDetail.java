package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookingDetail extends BaseEntity {
    private String description;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private BookingType type;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Date reservedDate;
    private Date checkinDate;
    private Date checkoutDate;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    private Room room;

    public String getDescription() {
        return description;
    }

    public BookingDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingDetail setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public BookingType getType() {
        return type;
    }

    public BookingDetail setType(BookingType type) {
        this.type = type;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingDetail setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public BookingDetail setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
        return this;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public BookingDetail setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
        return this;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public BookingDetail setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
        return this;
    }

    public Booking getBooking() {
        return booking;
    }

    public BookingDetail setBooking(Booking booking) {
        this.booking = booking;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public BookingDetail setRoom(Room room) {
        this.room = room;
        return this;
    }
}
