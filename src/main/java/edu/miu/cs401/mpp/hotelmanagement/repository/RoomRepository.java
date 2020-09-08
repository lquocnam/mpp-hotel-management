package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {

    //Select * from Room where type = ?1 and room_no =?2
    Collection<Room> findByRoomTypeAndRoomNo(RoomType roomType, String roomNo);

    @Query("SELECT r FROM Room as r WHERE r.id NOT IN (SELECT bd.id FROM BookingDetail as bd WHERE bd.type NOT IN (edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Reservation, edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Checkin))")
    Set<Room> findAvailableRooms();

    @Query("SELECT r FROM Room as r WHERE r.id IN (SELECT bd.id FROM BookingDetail as bd WHERE bd.type NOT IN (edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Reservation, edu.miu.cs401.mpp.hotelmanagement.entity.BookingType.Checkin))")
    Set<Room> findOccupiedRooms();
}
