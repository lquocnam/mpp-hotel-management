package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}
