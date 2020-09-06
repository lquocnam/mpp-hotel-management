package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class BookingEntry extends BaseEntity {
    @OneToMany
    Set<BookingEntryDetail> details;
    private String bookingNo;
    private Integer quantity;
    private String description;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private BookingType type;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @OneToOne
    private BookingEntry reference;
    @ManyToOne
    private Guest guest;

    public String getBookingNo() {
        return bookingNo;
    }

    public BookingEntry setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BookingEntry setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookingEntry setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public BookingEntry setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public BookingEntry setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingEntry setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public BookingType getType() {
        return type;
    }

    public BookingEntry setType(BookingType type) {
        this.type = type;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingEntry setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public BookingEntry getReference() {
        return reference;
    }

    public BookingEntry setReference(BookingEntry reference) {
        this.reference = reference;
        return this;
    }

    public Guest getGuest() {
        return guest;
    }

    public BookingEntry setGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public Set<BookingEntryDetail> getDetails() {
        return details;
    }

    public BookingEntry setDetails(Set<BookingEntryDetail> details) {
        this.details = details;
        return this;
    }
}
