package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDTO;
import edu.miu.cs401.mpp.hotelmanagement.entity.Status;

import java.util.List;

public interface BookingEntryService extends  Service<BookingEntryDTO, Long>{
    List<BookingEntryDTO> findByBookingNoAndStatus(String bookingNo, Status status);
    List<BookingEntryDTO> findByReferenceID(Integer id);
//    List<BookingEntryDTO> findByByGuestName(String firstName, Status status);
}
