package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingStatus;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDto {
    private Long id;
    private String bookingNo;
    private String notes;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;
    private Double amount;
    private Long roomId;
    private BookingType type;
    private BookingStatus status;
    private GuestDto guest;

    public Long getId() {
        return id;
    }

    public BookingDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public BookingDto setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public BookingDto setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public BookingDto setFromDate(Date fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public Date getToDate() {
        return toDate;
    }

    public BookingDto setToDate(Date toDate) {
        this.toDate = toDate;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingDto setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Long getRoomId() {
        return roomId;
    }

    public BookingDto setRoomId(Long roomId) {
        this.roomId = roomId;
        return this;
    }

    public BookingType getType() {
        return type;
    }

    public BookingDto setType(BookingType type) {
        this.type = type;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingDto setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public GuestDto getGuest() {
        return guest;
    }

    public BookingDto setGuest(GuestDto guest) {
        this.guest = guest;
        return this;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", bookingNo='" + bookingNo + '\'' +
                ", notes='" + notes + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", amount=" + amount +
                ", roomId=" + roomId +
                ", status=" + status +
                ", guest=" + guest +
                '}';
    }
}
