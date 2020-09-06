package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingEntryDetailRepository extends JpaRepository<BookingEntryDetail, Long> {
}
