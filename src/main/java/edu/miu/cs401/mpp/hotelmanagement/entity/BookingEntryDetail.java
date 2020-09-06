package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class BookingEntryDetail extends BaseEntity {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String description;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    private BookingEntry bookingEntry;

    @ManyToOne
    private Room room;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public BookingEntryDetail setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public BookingEntryDetail setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookingEntryDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingEntryDetail setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingEntryDetail setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public BookingEntry getBookingEntry() {
        return bookingEntry;
    }

    public BookingEntryDetail setBookingEntry(BookingEntry bookingEntry) {
        this.bookingEntry = bookingEntry;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public BookingEntryDetail setRoom(Room room) {
        this.room = room;
        return this;
    }
}
