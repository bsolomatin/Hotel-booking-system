package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Role;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class SignUpController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String registration() {return "registration";}

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userService.findByUserName(user.getUsername());
        if(userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setRoles(Role.USER);
        user.setEnabled(true);
        userService.saveUser(user);
        return "redirect:/login";
    }
}
