package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import com.bsolomatin.bookingshotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("bookings")
    public String getBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "bookingList";
    }

    @GetMapping("rooms")
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        return "roomsList";
    }

//    @GetMapping("users")
//    public List<User> userList() {
//        return userService.findAll();
//    }
//
//    @GetMapping("users/{id}")
//    public String userEditForm(@PathVariable String id, Model model) {
//        User user = userService.findById(Long.valueOf(id));
//        model.addAttribute("user", user);
//        return "userEdit";
//    }
//
//    @PostMapping("user")
//    public String userSave(@RequestParam String username, @RequestParam("userId") String userId) {
//        User user = userService.findById(Long.valueOf(userId));
//        user.setUsername(username);
//        userService.saveUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("rooms")
//    public List<Room> getRooms() {
//        return roomService.findAll();
//    }
//
//    @GetMapping("bookings")
//    public List<Booking> getBookings() {
//        return bookingService.findAll();
//    }
}
