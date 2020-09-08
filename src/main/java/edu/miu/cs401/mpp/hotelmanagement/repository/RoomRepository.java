package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room as r WHERE r.id NOT IN (SELECT bd.room.id FROM BookingDetail as bd WHERE bd.type IN (edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Reservation, edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Checkin))")
    Set<Room> findAvailableRooms();

    @Query("SELECT r FROM Room as r WHERE r.id IN (SELECT bd.room.id FROM BookingDetail as bd WHERE bd.type IN (edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Reservation, edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Checkin))")
    Set<Room> findOccupiedRooms();
}
