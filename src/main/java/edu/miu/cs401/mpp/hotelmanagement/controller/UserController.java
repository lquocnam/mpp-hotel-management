package edu.miu.cs401.mpp.hotelmanagement.controller;

import edu.miu.cs401.mpp.hotelmanagement.dto.RoomDto;
import edu.miu.cs401.mpp.hotelmanagement.dto.UserDto;
import edu.miu.cs401.mpp.hotelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('SUPER')")
    public String list(Model model) {
        List<UserDto> all = userService.getAll();
        System.out.println(all);
        model.addAttribute("users", all);
        return "user/list";
    }

    @RequestMapping("user/{id}")
    public String detail(@PathVariable String username, Model model) {
        model.addAttribute("user", userService.getById(username));
        return "user/detail";
    }

    @RequestMapping("users/edit/{id}")
    public String edit(@PathVariable String username, Model model) {
        return "user/edit";
    }

    @RequestMapping("user/create")
    public String create(Model model) {
        return "user/create";
    }

//    @RequestMapping(value = "users", method = RequestMethod.POST)
//    public String save(UserDto user) {
//        return "redirect:/users/" + userService.getById();
//    }

    @RequestMapping("users/delete/{id}")
    public String delete(@PathVariable String username) {
        return "redirect:/users/list";
    }
}
