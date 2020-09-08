package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.Booking;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingStatus;
import edu.miu.cs401.mpp.hotelmanagement.repository.BookingRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingService;
import edu.miu.cs401.mpp.hotelmanagement.service.converter.GuestConverter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl extends BaseService<Booking, BookingDto, Long> implements BookingService {

    private final GuestConverter guestConverter;

    public BookingServiceImpl(GuestConverter guestConverter) {
        this.guestConverter = guestConverter;
    }

    @Override
    public List<BookingDto> getOpenBookingsByGuest(GuestDto guestDto) {
        return Optional.ofNullable(guestConverter.fromDto(guestDto))
                .map(g -> ((BookingRepository) repository).findByGuest(g)
                        .stream()
                        .filter(b -> BookingStatus.Open.equals(b.getStatus()))
                        .map(b -> converter.toDto(b)).collect(Collectors.toList())).orElse(Collections.emptyList());
    }
}
