package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;

import java.util.List;

public interface BookingDetailService extends Service<BookingDetailDto, Long> {
    List<BookingDetailDto> getByBooking(BookingDto booking);

    List<BookingDetailDto> getReservation();

    List<BookingDetailDto> getCheckin();

    List<BookingDetailDto> getCheckout();
}
