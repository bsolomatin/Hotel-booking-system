package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Role;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class SignUpController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/registration", produces = "text/html")
    public String registration() {return "registration";}

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        User userFromDb = userService.findByUserName(user.getUsername());
        if(userFromDb != null) {
            return "registration";
        }

        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}
