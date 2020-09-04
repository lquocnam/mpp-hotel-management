package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;

public interface UserService extends Service<UserDto, String> {
    User saveOrUpdate(User user);
}
