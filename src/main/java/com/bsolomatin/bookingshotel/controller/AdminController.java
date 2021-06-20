package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Role;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.UsersRepository;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import com.bsolomatin.bookingshotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList :: list";
    }

    @GetMapping("bookings")
    public String getBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "bookingList";
    }

    @GetMapping("rooms")
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        return "roomList";
    }

//    @GetMapping("users")
//    public List<User> userList() {
//        return userService.findAll();
//    }
//
    @GetMapping("users/{id}")
    public String userEditForm(@PathVariable String id, Model model) {
        User user = userService.findById(Long.valueOf(id));
        model.addAttribute("u", user);
        return "userList :: user";
    }
//
    @PostMapping("user")
    public String userSave(Model model, @RequestParam String username, @RequestParam("roles") String role, @RequestParam("userId") Long id) {
        User user = userService.findById(id);
        if(userService.findByUserName(username) == null || userService.findByUserName(username).getId() == user.getId()) {
            user.setUsername(username);
            System.out.println(username + " " + role + " " + id);
            user.setRoles(Role.valueOf(role));
            usersRepository.save(user);
            System.err.println("Go to if condition");
            model.addAttribute("users", userService.findAll());
            return "userList :: list";
        } else {
            model.addAttribute("u", user);
            return "userlist :: user";
        }
    }
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
