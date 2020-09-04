package edu.miu.cs401.mpp.hotelmanagement.config;

import edu.miu.cs401.mpp.hotelmanagement.entity.Role;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoleRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public DataInitializer(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadUsers();
    }

    private void loadUsers() {
        User user = new User();
        user.setName("Administrator").setUsername("admin").setPassword("admin");
        Role adminRole = new Role();
        adminRole.setCode("ADMIN").setName("Admin");
        user.setRoles(new HashSet(Collections.singletonList(roleRepository.save(adminRole))));
        userService.saveOrUpdate(user);
    }
}
