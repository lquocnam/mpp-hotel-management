package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Booking extends BaseEntity {
    private String bookingNo;
    private String notes;
    private Date fromDate;
    private Date toDate;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private BookingType type;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @ManyToOne
    private Guest guest;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private Set<BookingDetail> details;

    public String getBookingNo() {
        return bookingNo;
    }

    public Booking setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Booking setNotes(String description) {
        this.notes = description;
        return this;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Booking setFromDate(Date fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public Date getToDate() {
        return toDate;
    }

    public Booking setToDate(Date toDate) {
        this.toDate = toDate;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Booking setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public BookingType getType() {
        return type;
    }

    public Booking setType(BookingType type) {
        this.type = type;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Booking setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public Guest getGuest() {
        return guest;
    }

    public Booking setGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public Set<BookingDetail> getDetails() {
        return details;
    }

    public Booking setDetails(Set<BookingDetail> entryDetails) {
        this.details = entryDetails;
        return this;
    }
}
