package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.AddressDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Address;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AddressConverter extends Converter<Address, AddressDto> {
}
