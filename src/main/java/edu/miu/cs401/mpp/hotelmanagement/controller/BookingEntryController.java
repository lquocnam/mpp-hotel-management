package edu.miu.cs401.mpp.hotelmanagement.controller;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDTO;
import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookingEntryController {

    private final BookingEntryService bookingEntryService;

    public BookingEntryController(BookingEntryService bookingEntryService) {
        this.bookingEntryService = bookingEntryService;
    }

    @RequestMapping(value = "/bookingentries", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String list(Model model) {
        List<BookingEntryDTO> all = bookingEntryService.getAll();
        System.out.println("Test Data..........");
        System.out.println(all);
        model.addAttribute("bookingentries", all);
        return "bookingentry/list";
    }

    @RequestMapping("bookingentries/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("bookingentries", bookingEntryService.getById(id));
        return "bookingentry/detail";
    }




}
