package edu.miu.cs401.mpp.hotelmanagement.facade;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;

public interface BookingFacade {

    BookingDto createOrUpdate(BookingDto booking);

    BookingDetailDto createOrUpdate(BookingDetailDto detail);

    void updateBookingAmount(BookingDto booking);

    void checkout(BookingDto dto);
}
