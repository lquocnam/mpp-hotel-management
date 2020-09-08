package edu.miu.cs401.mpp.hotelmanagement.facade;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;

public interface BookingFacade {

    BookingDto createNew(BookingDto dto);

    BookingDetailDto createOrUpdate(BookingDetailDto dto);
}
