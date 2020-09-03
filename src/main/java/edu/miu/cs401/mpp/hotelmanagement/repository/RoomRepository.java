package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.data.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
}
