package edu.miu.cs401.mpp.hotelmanagement.facade;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingStatus;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingType;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingDetailService;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingService;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingFacadeImpl implements BookingFacade {

    private final BookingService bookingService;
    private final BookingDetailService bookingDetailService;
    private final RoomService roomService;

    public BookingFacadeImpl(BookingService bookingService, BookingDetailService bookingDetailService, RoomService roomService) {
        this.bookingService = bookingService;
        this.bookingDetailService = bookingDetailService;
        this.roomService = roomService;
    }


    @Override
    public BookingDetailDto createOrUpdate(BookingDetailDto dto) {
        if (dto.getBooking().getId() != null) {
            return bookingService.getById(dto.getBooking().getId()).map(b -> {
                dto.setBooking(b).setStatus(BookingStatus.Open);
                switch (dto.getType()) {
                    case Reservation:
                        dto.setReservedDate(new Date());
                        break;
                    case Checkin:
                        dto.setCheckinDate(new Date());
                        break;
                    case Checkout:
                        dto.setCheckoutDate(new Date());
                        break;
                }
                return bookingDetailService.update(dto);
            }).orElse(dto);
        }
        return dto;
    }

    /**
     * Create a new booking with one details
     *
     * @param dto contains info of a booking
     * @return
     */
    @Override
    public BookingDto createNew(BookingDto dto) {
        return roomService.getById(dto.getRoomId()).map(r -> {
            dto.setStatus(BookingStatus.Open);
            BookingDto created = bookingService.update(dto);
            BookingDetailDto detailDto = new BookingDetailDto();
            detailDto.setRoom(r)
                    .setType(BookingType.Reservation)
                    .setStatus(BookingStatus.Open)
                    .setReservedDate(new Date())
                    .setBooking(created);
            bookingDetailService.update(detailDto);
            return created;
        }).orElseThrow(() -> new IllegalArgumentException("The room does not exist"));
    }
}
