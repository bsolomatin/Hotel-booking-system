package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private RoomService roomService;

//    @GetMapping("/index")
//    public String greeting(Model model, @AuthenticationPrincipal User user) {
//        model.addAttribute("user", user);
//        model.addAttribute("rooms", roomService.findAll());
//        return "index";
//    }

    @GetMapping("/")
    public String getContent(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("main", roomService.findAll());
        System.err.println("TEE");
        return "index";
    }

    @GetMapping("/error")
    public String getError() {
        return "error";
    }

    @GetMapping("/block")
    public String getBlock() { return "index";}

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String admin() {return "admin";}

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/manager")
    public String manager() {return "manager";}
}
