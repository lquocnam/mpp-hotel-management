package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingStatus;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDetailDto {
    private Long id;
    private String description;
    private Double amount;
    private BookingType type;
    private BookingStatus status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkoutDate;
    private RoomDto room;
    private BookingDto booking;

    public Long getId() {
        return id;
    }

    public BookingDetailDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookingDetailDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingDetailDto setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public BookingType getType() {
        return type;
    }

    public BookingDetailDto setType(BookingType type) {
        this.type = type;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingDetailDto setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public BookingDetailDto setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
        return this;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public BookingDetailDto setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
        return this;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public BookingDetailDto setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
        return this;
    }

    public RoomDto getRoom() {
        return room;
    }

    public BookingDetailDto setRoom(RoomDto room) {
        this.room = room;
        return this;
    }

    public BookingDto getBooking() {
        return booking;
    }

    public BookingDetailDto setBooking(BookingDto booking) {
        this.booking = booking;
        return this;
    }

    @Override
    public String toString() {
        return "BookingDetailDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", status=" + status +
                ", reservedDate=" + reservedDate +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", room=" + room +
                ", booking=" + booking +
                '}';
    }
}
