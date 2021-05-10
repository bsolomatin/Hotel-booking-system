package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class TestController {

//    @PostMapping("/test")
//    public String getData(@RequestParam("from") String from, @RequestParam("to") String to,
//                          @RequestParam("roomId") String roomId) {
//        System.out.println(from + " " + to + " " + roomId);
//        return "done";
//    }

    @PostMapping("/test")
    public String getData(@ModelAttribute("booking")Booking booking) {
        System.out.println(booking.toString());
        return "done";
    }

//    @PostMapping("/test")
//    public String getData(@RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut,
//                          @RequestParam("roomId") String roomId, @AuthenticationPrincipal User user) {
//        LocalDate in = LocalDate.of(Integer.valueOf(checkIn.split("-")[0]),
//                Integer.valueOf(checkIn.split("-")[1]), Integer.valueOf(checkIn.split("-")[2]));
//        LocalDate out = LocalDate.of(Integer.valueOf(checkOut.split("-")[0]),
//                Integer.valueOf(checkOut.split("-")[1]), Integer.valueOf(checkOut.split("-")[2]));
//        int rId = Integer.valueOf(roomId);
//        int uId = user.getId().intValue();
//        Booking booking = new Booking(true, in, out, uId, rId);
//        System.out.println(booking.toString());
//
//        return "done";
//    }
}
