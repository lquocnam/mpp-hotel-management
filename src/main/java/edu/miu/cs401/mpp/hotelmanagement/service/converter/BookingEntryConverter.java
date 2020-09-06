package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookingEntryConverter extends Converter<BookingEntry, BookingEntryDto> {
}
