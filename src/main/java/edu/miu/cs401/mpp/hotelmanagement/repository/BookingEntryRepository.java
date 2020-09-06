package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingEntryRepository extends JpaRepository<BookingEntry, Long> {
}
