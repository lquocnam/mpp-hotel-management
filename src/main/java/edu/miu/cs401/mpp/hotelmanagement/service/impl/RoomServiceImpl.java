package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Room;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends BaseService<Room, RoomDto, String> implements RoomService {
}
