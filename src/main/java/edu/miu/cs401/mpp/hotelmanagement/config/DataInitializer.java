package edu.miu.cs401.mpp.hotelmanagement.config;

import edu.miu.cs401.mpp.hotelmanagement.entity.*;
import edu.miu.cs401.mpp.hotelmanagement.repository.GuestRepository;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoleRepository;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoomRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public DataInitializer(UserService userService, RoleRepository roleRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadUsers();
        loadRooms();
        loadGuests();
    }

    private void loadUsers() {
        Role adminRole = roleRepository.save(new Role().setCode(RoleCode.ADMIN).setName("Admin"));
        Role staffRole = roleRepository.save(new Role().setCode(RoleCode.STAFF).setName("Staff"));
        User user = new User();
        user.setName("Super Administrator").setUsername("superadmin").setPassword("nimda");
        user.setRoles(new HashSet(Arrays.asList(adminRole, staffRole)));
        userService.saveOrUpdate(user);

        user.setName("Administrator").setUsername("admin").setPassword("nimda");
        user.setRoles(new HashSet(Collections.singletonList(adminRole)));
        userService.saveOrUpdate(user);

        user.setName("Staff").setUsername("staff").setPassword("nimda");
        user.setRoles(new HashSet(Collections.singletonList(staffRole)));
        userService.saveOrUpdate(user);
    }

    private void loadRooms() {
        Room room = new Room().setRoomNo("101").setCapacity(2).setRoomType(RoomType.Single).setPrice(100.0);
        Room room1 = new Room().setRoomNo("102").setCapacity(2).setRoomType(RoomType.Single).setPrice(100.0);
        Room room2 = new Room().setRoomNo("103").setCapacity(2).setRoomType(RoomType.Double).setPrice(120.0);
        Room room3 = new Room().setRoomNo("104").setCapacity(2).setRoomType(RoomType.Double).setPrice(120.0);
        Room room4 = new Room().setRoomNo("105").setCapacity(2).setRoomType(RoomType.Twin).setPrice(150.0);
        Room room5 = new Room().setRoomNo("106").setCapacity(2).setRoomType(RoomType.Twin).setPrice(150.0);
        Room room6 = new Room().setRoomNo("107").setCapacity(2).setRoomType(RoomType.Triple).setPrice(200.0);
        roomRepository.saveAll(Arrays.asList(room, room1, room2, room3, room4, room5, room6));
    }

    private void loadGuests() {
        Guest guest = new Guest().setFirstName("Anna").setLastName("Bob").setDob(new Date(1985, 2, 2))
                .setGender(Gender.Female).setPhoneNumber("6411981234")
                .setAddress(new Address().setStreet("1000N 4th").setCity("Fairfield").setState("Iowa").setZip("52557"));
        Guest guest2 = new Guest().setFirstName("Quoc Nam").setLastName("Le").setDob(new Date(1985, 2, 2))
                .setGender(Gender.Female).setPhoneNumber("6411981234")
                .setAddress(new Address().setStreet("1000N 4th").setCity("Fairfield").setState("Iowa").setZip("52557"));
        Guest guest3 = new Guest().setFirstName("Duy Thai").setLastName("Nguyen").setDob(new Date(1985, 2, 2))
                .setGender(Gender.Female).setPhoneNumber("6411981234")
                .setAddress(new Address().setStreet("1000N 4th").setCity("Fairfield").setState("Iowa").setZip("52557"));
        Guest guest4 = new Guest().setFirstName("Duy Hanh").setLastName("Nguyen").setDob(new Date(1985, 2, 2))
                .setGender(Gender.Female).setPhoneNumber("6411981234")
                .setAddress(new Address().setStreet("1000N 4th").setCity("Fairfield").setState("Iowa").setZip("52557"));
        Guest guest5 = new Guest().setFirstName("Truong Thanh Nam").setLastName("Nguyen").setDob(new Date(1985, 2, 2))
                .setGender(Gender.Female).setPhoneNumber("6411981234")
                .setAddress(new Address().setStreet("1000N 4th").setCity("Fairfield").setState("Iowa").setZip("52557"));
        guestRepository.saveAll(Arrays.asList(guest, guest2, guest3, guest4));
    }
}
