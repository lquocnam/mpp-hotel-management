package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;

import java.util.List;

public interface RoomService extends Service<RoomDto, Long> {
    List<RoomDto> searchBy(RoomType roomType, String roomNo);

    List<RoomType> getRoomTypes();
}
