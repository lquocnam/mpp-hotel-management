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
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String list(Model model) {
        List<RoomDto> all = roomService.getAll();
        System.out.println(all);
        model.addAttribute("rooms", all);
        return "room/list";
    }

    @RequestMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getById(id));
        return "room/detail";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("roomTypes", roomService.getRoomTypes());
        return "room/create";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        RoomDto room = roomService.getById(id);
        model.addAttribute("roomTypes", roomService.getRoomTypes());
        model.addAttribute("room", room);
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
