package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("bookings", bookingService.getReservationByUser(user.getId().intValue()));
        return "profile";
    }

    @PostMapping("book")
    public String book(@ModelAttribute("booking")Booking booking, @AuthenticationPrincipal User user) {
        booking.setUserId(user.getId().intValue());
        return "redirect:/user/profile";
    }

}
