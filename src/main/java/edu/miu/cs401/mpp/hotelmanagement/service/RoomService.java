package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import edu.miu.cs401.mpp.hotelmanagement.entity.RoomType;

import java.util.List;
import java.util.Set;

public interface RoomService extends Service<RoomDto, Long> {

    List<RoomType> getRoomTypes();

    List<BookingType> getBookingTypes();

    Set<RoomDto> getAvailableRooms();

    Set<RoomDto> getOccupiedRooms();
}
