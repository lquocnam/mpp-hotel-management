package edu.miu.cs401.mpp.hotelmanagement.service.converter;

import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {RoleConverter.class})
@Component
public interface UserConverter extends Converter<User, UserDto> {
}
