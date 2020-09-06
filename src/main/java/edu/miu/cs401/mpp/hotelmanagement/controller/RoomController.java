package edu.miu.cs401.mpp.hotelmanagement.controller;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String list(Model model) {
        List<RoomDto> all = roomService.getAll();
        System.out.println(all);
        model.addAttribute("rooms", all);
        return "room/list";
    }

    @RequestMapping("rooms/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getById(id));
        return "room/detail";
    }

    @RequestMapping("rooms/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        return "room/edit";
    }

    @RequestMapping("rooms/create")
    public String create(Model model) {
        return "room/create";
    }

    @RequestMapping(value = "rooms", method = RequestMethod.POST)
    public String save(RoomDto room) {
        return "redirect:/rooms/" + room.getId();
    }

    @RequestMapping("rooms/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return "redirect:/rooms/list";
    }
}
