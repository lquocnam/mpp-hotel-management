package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.Booking;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingDetail;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long> {

    List<BookingDetail> findByBooking(Booking booking);

    List<BookingDetail> findByRoom(Room room);
}
