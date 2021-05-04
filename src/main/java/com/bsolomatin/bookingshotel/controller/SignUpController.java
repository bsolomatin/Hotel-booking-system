package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.forms.UserForm;
import com.bsolomatin.bookingshotel.service.UserService;
import com.bsolomatin.bookingshotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String registration() {return "registration";}

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userService.findByUserName(user.getLogin());
        if(userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
