package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RoomRepository extends JpaRepository<Room, Long> {

    //Select * from Room where type = ?1 and room_no =?2
    Collection<Room> findByRoomTypeAndRoomNo(RoomType roomType, String roomNo);

//    @Query("select * from Room inner join User ")
//    Collection<Room> customQuery(RoomType roomType, String roomNo);
}
