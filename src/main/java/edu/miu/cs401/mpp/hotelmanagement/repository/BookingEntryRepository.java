package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import edu.miu.cs401.mpp.hotelmanagement.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface BookingEntryRepository extends JpaRepository<BookingEntry, Long> {
    Collection<BookingEntry> findByBookingNoAndStatus(String bookingNo, Status status);

    Collection<BookingEntry> findByReferenceID(Integer id);

//    @Query("select BookingEntry from BookingEntry, Guest where BookingEntry.guestID = Guest.id " +
//            "and Guest.firstName like '%?%' and BookingEntry.status = '?'")
//    Collection<BookingEntry> findByByGuestName(String firstName, Status status);
}
