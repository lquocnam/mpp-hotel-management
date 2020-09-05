package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDTO;
import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookingEntryConverter extends Converter<BookingEntry, BookingEntryDTO> {
}
