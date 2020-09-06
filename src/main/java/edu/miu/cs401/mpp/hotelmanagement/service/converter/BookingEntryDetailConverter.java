package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntryDetail;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookingEntryDetailConverter extends Converter<BookingEntryDetail, BookingEntryDetailDto> {
}
