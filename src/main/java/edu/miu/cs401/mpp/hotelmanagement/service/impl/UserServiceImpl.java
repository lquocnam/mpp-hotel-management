package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import edu.miu.cs401.mpp.hotelmanagement.repository.UserRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<UserDto> searchByN(String username) {
        UserRepository userRepository = (UserRepository) repository;
        Optional<User> list = userRepository.findByUsername(username);
        return list.map(u->converter.toDto(u));
    }
}
