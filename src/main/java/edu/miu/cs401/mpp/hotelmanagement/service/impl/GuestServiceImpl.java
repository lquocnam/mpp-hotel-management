package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Gender;
import edu.miu.cs401.mpp.hotelmanagement.entity.Guest;
import edu.miu.cs401.mpp.hotelmanagement.service.GuestService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GuestServiceImpl extends BaseService<Guest, GuestDto, Long> implements GuestService {

    @Override
    public List<Gender> getGenders() {
        return Arrays.asList(Gender.values());
    }
}
