package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("users/{id}")
    public String userEditForm(@PathVariable String id, Model model) {
        User user = userService.findById(Long.valueOf(id));
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping("user")
    public String userSave(@RequestParam String username, @RequestParam("userId") String userId) {
        User user = userService.findById(Long.valueOf(userId));
        user.setUsername(username);
        userService.saveUser(user);
        return "redirect:/users";
    }
}