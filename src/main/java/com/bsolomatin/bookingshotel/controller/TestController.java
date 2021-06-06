package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;

//@RestController
@Controller
public class TestController {

//    @PostMapping("/search")
//    public String getSearchResult(@RequestParam("cI") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
//                                  @RequestParam("cO") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut,
//                                  @RequestParam("count")Integer count) {
//        System.out.println("Check in " + checkIn);
//        System.out.println("Check out " + checkOut);
//        System.out.println("Count " + count);
        //System.out.println(d1 + " " + d2 + " " + count);
        //return "error";
        //List<Room> list = roomService.getRoomsByIdNotIn(cI, cO);
        //if(list != null) return list;
        //else  return roomService.findAll();
    //}

//    @PostMapping("/test")
//    public String getData(@RequestParam("from") String from, @RequestParam("to") String to,
//                          @RequestParam("roomId") String roomId) {
//        System.out.println(from + " " + to + " " + roomId);
//        return "done";
//    }

//    @PostMapping("/test")
//    public String getData(@ModelAttribute("booking")Booking booking) {
//        System.out.println(booking.toString());
//        return "done";
//    }
    @PostMapping("/test")
    public ResponseEntity getData(@ModelAttribute("booking")Booking booking) {
        System.out.println(booking.toString());
        return new ResponseEntity(HttpStatus.OK);
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
