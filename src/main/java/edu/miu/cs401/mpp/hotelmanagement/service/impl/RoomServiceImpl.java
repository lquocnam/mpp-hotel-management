package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.RoomStatus;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoomRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends BaseService<Room, RoomDto, Long> implements RoomService {

    @Override
    public List<RoomType> getRoomTypes() {
        return Arrays.asList(RoomType.values());
    }

    @Override
    public List<BookingType> getBookingTypes() {
        return Arrays.asList(BookingType.values());
    }

    @Override
    public List<RoomDto> getAll() {
        List<RoomDto> rooms = super.getAll();
        Set<RoomDto> availableRooms = getAvailableRooms();
        Set<RoomDto> occupiedRooms = getOccupiedRooms();
        for (RoomDto room : rooms) {
            if (availableRooms.contains(room)) {
                room.setStatus(RoomStatus.Available);
            } else if (occupiedRooms.contains(room)) {
                room.setStatus(RoomStatus.Occupied);
            } else {
                room.setStatus(RoomStatus.Reserved);
            }
        }
        return rooms;
    }

    @Override
    public Set<RoomDto> getAvailableRooms() {
        return ((RoomRepository) repository).findAvailableRooms().stream().map(converter::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<RoomDto> getOccupiedRooms() {
        return ((RoomRepository) repository).findOccupiedRooms().stream().map(converter::toDto).collect(Collectors.toSet());
    }
}
