package edu.miu.cs401.mpp.hotelmanagement.controller;


import edu.miu.cs401.mpp.hotelmanagement.dto.BookingDto;
import edu.miu.cs401.mpp.hotelmanagement.facade.BookingFacade;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingDetailService;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingService;
import edu.miu.cs401.mpp.hotelmanagement.service.GuestService;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final static Logger LOG = LoggerFactory.getLogger(BookingController.class);

    private final GuestService guestService;
    private final RoomService roomService;
    private final BookingService bookingService;
    private final BookingDetailService bookingDetailService;
    private final BookingFacade bookingFacade;

    public BookingController(GuestService guestService, RoomService roomService, BookingService bookingService, BookingDetailService bookingDetailService, BookingFacade bookingFacade) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.bookingService = bookingService;
        this.bookingDetailService = bookingDetailService;
        this.bookingFacade = bookingFacade;
    }

    @GetMapping(value = "")
    public String bookingInfo(Model model, @RequestParam(name = "guestId") Long guestId) {
        guestService.getById(guestId).ifPresent(g -> {
            model.addAttribute("guest", g);
            model.addAttribute("bookings", bookingService.getOpenBookingsByGuest(g));
            model.addAttribute("availableRooms", roomService.getAvailableRooms());
        });
        return "booking/info";
    }

    @RequestMapping("/create")
    public String create(Model model, @RequestParam(name = "guestId") Long guestId) {
        guestService.getById(guestId).ifPresent(g -> {
            LOG.info("Create new booking for guestID: {}", guestId);
            model.addAttribute("availableRooms", roomService.getAvailableRooms());
        });
        return "booking/create";
    }

    @RequestMapping("/reserve")
    public String reserve(Model model) {
        model.addAttribute("details", bookingDetailService.getReservation());
        return "booking/reserve";
    }

    @RequestMapping("/checkin")
    public String checkin(Model model) {
        model.addAttribute("details", bookingDetailService.getCheckin());
        return "booking/checkin";
    }

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("details", bookingDetailService.getCheckout());
        return "booking/checkout";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        bookingService.getById(id).ifPresent(dto -> {
            LOG.info("Create new booking for guestID: {}", dto.getGuest().getId());
            model.addAttribute("details", bookingDetailService.getByBooking(dto));
            model.addAttribute("booking", dto);
            model.addAttribute("guest", dto.getGuest());
        });
        return "booking/edit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(BookingDto booking) {
        BookingDto updatedBooking = bookingFacade.createNew(booking);
        return "redirect:/bookings/edit/" + updatedBooking.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam(name = "guestId") Long guestId) {
        bookingService.delete(id);
        return "redirect:/bookings?guestId=" + guestId;
    }
}
