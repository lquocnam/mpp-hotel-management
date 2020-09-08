package edu.miu.cs401.mpp.hotelmanagement.controller;

import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String list(Model model) {
        List<UserDto> all = userService.getAll();
        System.out.println(all);
        model.addAttribute("users", all);
        return "user/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
//        model.addAttribute("roomTypes", userService.getRoomTypes());
        return "user/create";
    }

    @RequestMapping("/edit/{username}")
    public String edit(@PathVariable String username, Model model) {
        userService.getById(username).ifPresent(u -> model.addAttribute("user", u));
//        model.addAttribute("roomTypes", userService.getRoomTypes());
        ;
        return "user/edit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(UserDto user) {
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return "redirect:/users";
    }
}
