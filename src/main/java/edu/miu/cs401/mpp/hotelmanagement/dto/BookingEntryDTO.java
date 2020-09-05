package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import edu.miu.cs401.mpp.hotelmanagement.entity.Status;

import javax.persistence.*;
import java.time.LocalDate;

public class BookingEntryDTO {

    private Long id;
    private String bookingNo;
    private BookingType bookingType;
    private Integer roomQuantity;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String description;
    private Double totalAmount;
    private Long referenceID;
    private Long guestID;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private Long createdBy;
    private Long modifiedBy;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Long referenceID) {
        this.referenceID = referenceID;
    }

    public Long getGuestID() {
        return guestID;
    }

    public void setGuestID(Long guestID) {
        this.guestID = guestID;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "BookingEntryDTO{" +
                "id=" + id +
                ", bookingNo='" + bookingNo + '\'' +
                ", bookingType=" + bookingType +
                ", roomQuantity=" + roomQuantity +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                ", totalAmount=" + totalAmount +
                ", referenceID=" + referenceID +
                ", guestID=" + guestID +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", status=" + status +
                '}';
    }
}
