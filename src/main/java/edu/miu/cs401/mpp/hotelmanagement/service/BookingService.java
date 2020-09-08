package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;

import java.util.List;

public interface BookingService extends Service<BookingDto, Long> {
    List<BookingDto> getOpenBookingsByGuest(GuestDto guestDto);
}
