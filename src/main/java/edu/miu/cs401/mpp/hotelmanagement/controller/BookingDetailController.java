package edu.miu.cs401.mpp.hotelmanagement.controller;


import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDetailDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.facade.BookingFacade;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingDetailService;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingService;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/bookings/detail")
public class BookingDetailController {

    private final static Logger LOG = LoggerFactory.getLogger(BookingDetailController.class);

    private final BookingFacade bookingFacade;
    private final RoomService roomService;
    private final BookingService bookingService;
    private final BookingDetailService bookingDetailService;

    public BookingDetailController(BookingFacade bookingFacade, RoomService roomService, BookingService bookingService, BookingDetailService bookingDetailService) {
        this.bookingFacade = bookingFacade;
        this.roomService = roomService;
        this.bookingService = bookingService;
        this.bookingDetailService = bookingDetailService;
    }

    @RequestMapping("/create")
    public String create(Model model, @RequestParam(name = "bookingId") Long bookingId) {
        bookingService.getById(bookingId).ifPresent(b -> {
            LOG.info("Create new booking detail.");
            model.addAttribute("booking", b);
            model.addAttribute("types", roomService.getBookingTypes());
            model.addAttribute("availableRooms", roomService.getAvailableRooms());
        });
        return "booking/detail/create";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        bookingDetailService.getById(id).ifPresent(detail -> {
            bookingService.getById(detail.getBooking().getId()).ifPresent(b -> {
                LOG.info("Edit new booking detail {}", id);
                model.addAttribute("booking", b);
                model.addAttribute("detail", detail);
                model.addAttribute("types", roomService.getBookingTypes());
                Set<RoomDto> availableRooms = roomService.getAvailableRooms();
                availableRooms.add(detail.getRoom());
                model.addAttribute("availableRooms", availableRooms);
            });
        });
        return "booking/detail/edit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(BookingDetailDto bookingDetail) {
        BookingDetailDto updatedDetail = bookingFacade.createOrUpdate(bookingDetail);
        return "redirect:/bookings/view/" + updatedDetail.getBooking().getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return bookingDetailService.getById(id).map(detail -> {
            bookingDetailService.delete(detail.getId());
            return "redirect:/bookings/view/" + detail.getBooking().getId();
        }).orElse("redirect:/bookings");
    }
}
