package edu.miu.cs401.mpp.hotelmanagement.service;

import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Gender;

import java.util.List;

public interface GuestService extends Service<GuestDto, Long> {

    List<Gender> getGenders();
}
