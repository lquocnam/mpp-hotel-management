package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingDetail;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {RoomConverter.class})
@Component
public interface BookingDetailConverter extends Converter<BookingDetail, BookingDetailDto> {
}
