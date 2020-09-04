package edu.miu.cs401.mpp.hotelmanagement.repository;

import edu.miu.cs401.mpp.hotelmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
