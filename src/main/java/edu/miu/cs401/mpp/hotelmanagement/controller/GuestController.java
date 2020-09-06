package edu.miu.cs401.mpp.hotelmanagement.controller;


import edu.miu.cs401.mpp.hotelmanagement.dto.GuestDto;
import edu.miu.cs401.mpp.hotelmanagement.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String list(Model model) {
        List<GuestDto> all = guestService.getAll();
        System.out.println(all);
        model.addAttribute("guests", all);
        return "guest/list";
    }

//    @RequestMapping("/{id}")
//    public String detail(@PathVariable Long id, Model model) {
//        model.addAttribute("room", roomService.getById(id));
//        return "room/detail";
//    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("genders", guestService.getGenders());
        return "guest/create";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        GuestDto guest = guestService.getById(id);
        model.addAttribute("genders", guestService.getGenders());
        model.addAttribute("guest", guest);
        return "guest/edit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(GuestDto guest) {
        guestService.update(guest);
        return "redirect:/guests";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        guestService.delete(id);
        return "redirect:/guests";
    }
}
