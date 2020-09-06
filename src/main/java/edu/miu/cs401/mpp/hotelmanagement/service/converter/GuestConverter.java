package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Guest;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {AddressConverter.class})
@Component
public interface GuestConverter extends Converter<Guest, GuestDto> {
}
