package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingDetail;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingStatus;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import edu.miu.cs401.mpp.hotelmanagement.repository.BookingDetailRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingDetailService;
import edu.miu.cs401.mpp.hotelmanagement.service.converter.BookingConverter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingDetailServiceImpl extends BaseService<BookingDetail, BookingDetailDto, Long> implements BookingDetailService {

    private final BookingConverter bookingConverter;

    public BookingDetailServiceImpl(BookingConverter bookingConverter) {
        this.bookingConverter = bookingConverter;
    }

    @Override
    public List<BookingDetailDto> getByBooking(BookingDto booking) {
        return ((BookingDetailRepository) repository).findByBooking(bookingConverter.fromDto(booking))
                .stream().map(bd -> converter.toDto(bd)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDetailDto> getReservation() {
        return getByType(BookingType.Reservation, Comparator.comparing(BookingDetailDto::getReservedDate).reversed());
    }

    @Override
    public List<BookingDetailDto> getCheckin() {
        return getByType(BookingType.Checkin, Comparator.comparing(BookingDetailDto::getCheckinDate).reversed());
    }

    @Override
    public List<BookingDetailDto> getCheckout() {
        return getByType(BookingType.Checkout, Comparator.comparing(BookingDetailDto::getCheckoutDate).reversed());
    }

    private List<BookingDetailDto> getByType(BookingType type, Comparator<BookingDetailDto> comparator) {
        return getAll().stream().filter(d -> type.equals(d.getType()))
                .filter(d -> BookingStatus.Open.equals(d.getStatus()))
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
