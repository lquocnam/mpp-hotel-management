package edu.miu.cs401.mpp.hotelmanagement.dto;

import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;

import java.util.Objects;

public class RoomDto {
    private Long id;

    private String roomNo;

    private Integer capacity;

    private Double price;

    private RoomType roomType;

    private RoomStatus status;

    public Long getId() {
        return id;
    }

    public RoomDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public RoomDto setRoomNo(String roomNo) {
        this.roomNo = roomNo;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public RoomDto setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public RoomDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomDto setRoomType(RoomType roomType) {
        this.roomType = roomType;
        return this;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public RoomDto setStatus(RoomStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(id, roomDto.id) &&
                Objects.equals(roomNo, roomDto.roomNo) &&
                Objects.equals(capacity, roomDto.capacity) &&
                Objects.equals(price, roomDto.price) &&
                roomType == roomDto.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNo, capacity, price, roomType);
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", roomNo='" + roomNo + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
