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
    public BookingDetailDto createOrUpdate(BookingDetailDto detail) {
        if (detail.getBooking() != null && detail.getBooking().getId() != null) {
            return bookingService.getById(detail.getBooking().getId()).map(b -> {
                detail.setBooking(b).setStatus(BookingStatus.Open);
                setDate(detail);
                if (detail.getRoom() != null && detail.getRoom().getId() != null) {
                    roomService.getById(detail.getRoom().getId()).ifPresent(r -> detail.setAmount(r.getPrice()));
                }
                BookingDetailDto updatedDetail = bookingDetailService.update(detail);
                updateBookingAmount(b);
                return updatedDetail;
            }).orElse(detail);
        }
        return detail;
    }

    /**
     * Create a new or update an existing booking with one details
     *
     * @param booking contains info of a booking
     * @return
     */
    @Override
    public BookingDto createOrUpdate(BookingDto booking) {
        if (booking.getId() != null && bookingService.getById(booking.getId()).isPresent()) {
            booking.setStatus(BookingStatus.Open);
            return bookingService.update(booking);
        } else {
            return roomService.getById(booking.getRoomId()).map(r -> {
                booking.setStatus(BookingStatus.Open);
                BookingDto created = bookingService.update(booking);
                BookingDetailDto detailDto = new BookingDetailDto();
                detailDto.setRoom(r)
                        .setType(booking.getType())
                        .setStatus(BookingStatus.Open)
                        .setBooking(created)
                        .setAmount(r.getPrice());
                setDate(detailDto);
                bookingDetailService.update(detailDto);
                updateBookingAmount(created);
                return created;
            }).orElseThrow(() -> new IllegalArgumentException("The room does not exist"));
        }
    }

    @Override
    public void updateBookingAmount(BookingDto booking) {
        double amount = bookingDetailService.getByBooking(booking).stream().mapToDouble(BookingDetailDto::getAmount).sum();
        booking.setAmount(amount);
        bookingService.update(booking);
    }

    @Override
    public void checkout(BookingDto dto) {
        dto.setStatus(BookingStatus.Completed);
        bookingService.update(dto);
        bookingDetailService.getByBooking(dto).forEach(detail -> {
            detail.setType(BookingType.Checkout);
            detail.setStatus(BookingStatus.Completed);
            detail.setCheckoutDate(new Date());
            bookingDetailService.update(detail);
        });
    }

    private void setDate(BookingDetailDto detail) {
        switch (detail.getType()) {
            case Reservation:
                detail.setReservedDate(new Date());
                break;
            case Checkin:
                detail.setCheckinDate(new Date());
                break;
            case Checkout:
                detail.setCheckoutDate(new Date());
                break;
        }
    }
}
