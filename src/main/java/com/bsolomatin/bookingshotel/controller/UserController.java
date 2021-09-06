package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomService roomService;

    @GetMapping("profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("bookings", bookingService.getReservationByUser(user.getId().intValue()));
        return "profile";
    }

    @PostMapping("book")
    public String book(Model model, @ModelAttribute("booking")Booking booking, @AuthenticationPrincipal User user) {
        booking.setUserId(user.getId().intValue());
        bookingService.save(booking);
        model.addAttribute("user", user);
        model.addAttribute("lastBook", booking);
        model.addAttribute("bookings", bookingService.getReservationByUser(user.getId().intValue()));
        model.addAttribute("message", "Вы успешно забронировали номер");
        return "profile";
    }

    @PostMapping("search")
    public String getSearchResult(Model model, @RequestParam("cI") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
                                      @RequestParam("cO") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut) {
        List<Room> list = roomService.getRoomsByIdNotIn(checkIn, checkOut);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        if(list != null) {
            model.addAttribute("results", list);
            return "searchResult :: results";
        }
        else {
            model.addAttribute("message", "В выбранные даты не нашлось свободных номеров");
            model.addAttribute("results", roomService.findAll());
            return "searchResult :: results";
        }
    }

}
