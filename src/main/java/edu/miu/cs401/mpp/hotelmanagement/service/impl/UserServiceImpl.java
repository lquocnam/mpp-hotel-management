package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User, UserDto, String> implements UserService {

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveOrUpdate(User user) {
        if (user.getPassword() != null) {
            user.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
        }
        return repository.save(user);
    }

    @Override
    public UserDto update(UserDto dto) {
        User user = converter.fromDto(dto);
        if (user.getPassword() != null) {
            user.setEncryptedPassword(passwordEncoder.encode(dto.getPassword()));
        }
        User savedUser = repository.save(user);
        return converter.toDto(savedUser);
    }
}
