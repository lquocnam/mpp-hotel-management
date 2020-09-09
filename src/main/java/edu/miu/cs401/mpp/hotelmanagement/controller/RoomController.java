package edu.miu.cs401.mpp.hotelmanagement.controller;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String allRooms(Model model) {
        List<RoomDto> all = roomService.getAll();
        System.out.println(all);
        model.addAttribute("rooms", all);
        model.addAttribute("title", "All Rooms");
        model.addAttribute("showAll", true);
        return "room/list";
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public String availableRooms(Model model) {
        Set<RoomDto> availableRooms = roomService.getAvailableRooms();
        System.out.println(availableRooms);
        model.addAttribute("rooms", availableRooms);
        model.addAttribute("title", "Available Rooms");
        model.addAttribute("showAll", false);
        return "room/list";
    }

    @RequestMapping(value = "/occupied", method = RequestMethod.GET)
    public String occupiedRooms(Model model) {
        Set<RoomDto> occupiedRooms = roomService.getOccupiedRooms();
        System.out.println(occupiedRooms);
        model.addAttribute("rooms", occupiedRooms);
        model.addAttribute("showGuestName", true);
        model.addAttribute("title", "Occupied Rooms");
        model.addAttribute("showAll", false);
        return "room/list";
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        roomService.getById(id).ifPresent(r -> model.addAttribute("room", r));
        model.addAttribute("roomTypes", roomService.getRoomTypes());
        return "room/view";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("roomTypes", roomService.getRoomTypes());
        return "room/create";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        roomService.getById(id).ifPresent(r -> model.addAttribute("room", r));
        model.addAttribute("roomTypes", roomService.getRoomTypes());
        return "room/edit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(RoomDto room) {
        roomService.update(room);
        return "redirect:/rooms";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        roomService.delete(id);
        return "redirect:/rooms";
    }
}
