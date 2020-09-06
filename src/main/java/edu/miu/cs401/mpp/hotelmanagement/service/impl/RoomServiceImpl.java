package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;
import edu.miu.cs401.mpp.hotelmanagement.repository.RoomRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends BaseService<Room, RoomDto, Long> implements RoomService {

    @Override
    public List<RoomDto> searchBy(RoomType roomType, String roomNo) {
        RoomRepository roomRepository = (RoomRepository) repository;
        Collection<Room> list = roomRepository.findByRoomTypeAndRoomNo(roomType, roomNo);
        return list.stream().map(r -> converter.toDto(r)).collect(Collectors.toList());
    }

    @Override
    public List<RoomType> getRoomTypes() {
        return Arrays.asList(RoomType.values());
    }
}
