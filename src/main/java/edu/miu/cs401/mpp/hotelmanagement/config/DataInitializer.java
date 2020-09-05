package edu.miu.cs401.mpp.hotelmanagement.config;

import edu.miu.cs401.mpp.hotelmanagement.entity.Role;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import edu.miu.cs401.mpp.hotelmanagement.entity.User;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoleRepository;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoomRepository;
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
    private final RoomRepository roomRepository;

    public DataInitializer(UserService userService, RoleRepository roleRepository, RoomRepository roomRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadUsers();
        loadRooms();
    }

    private void loadUsers() {
        User user = new User();
        user.setName("Administrator").setUsername("admin").setPassword("admin");
        Role adminRole = new Role();
        adminRole.setCode("ADMIN").setName("Admin");
        user.setRoles(new HashSet(Collections.singletonList(roleRepository.save(adminRole))));
        userService.saveOrUpdate(user);
    }

    private void loadRooms() {
        Room room = new Room();
        room.setRoomNo("101").setCapacity(2).setRoomType(RoomType.Double).setPrice(100.0);
        roomRepository.save(room);
    }
}
