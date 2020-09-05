package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Room extends BaseEntity {

    private String roomNo;

    private Integer capacity;

    private Double price;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    public String getRoomNo() {
        return roomNo;
    }

    public Room setRoomNo(String roomNo) {
        this.roomNo = roomNo;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Room setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Room setPrice(Double price) {
        this.price = price;
        return this;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Room setRoomType(RoomType roomType) {
        this.roomType = roomType;
        return this;
    }
}
