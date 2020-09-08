package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Booking;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {BookingDetailConverter.class, GuestConverter.class})
@Component
public interface BookingConverter extends Converter<Booking, BookingDto> {
}
