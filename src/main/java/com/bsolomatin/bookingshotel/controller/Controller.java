package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import com.bsolomatin.bookingshotel.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUsers() {return userService.findAll();}

    @GetMapping("rooms")
    public List<Room> getRooms() {
        return roomService.findAll();
    }

    @GetMapping("bookings")
    public List<Booking> getBookings() {
        return bookingService.findAll();
    }

    @GetMapping("bookings/{id}")
    public List<Booking> getReservations(@PathVariable String id) {
        return bookingService.getReservationByRoom(Integer.valueOf(id));
    }

    @GetMapping("room/{id}")
    public Room getRoom(@PathVariable String id) { return roomService.findById(Long.valueOf(id)); }

    //@ResponseStatus(code = HttpStatus.CREATED) // 201
    @PostMapping("block")
    public void addNewReservation(HttpServletRequest request, @AuthenticationPrincipal User user) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String[] from = request.getParameter("from").split("-");
        String[] to = request.getParameter("to").split("-" );
        LocalDate fromDate = LocalDate.of(Integer.parseInt(from[0]), Integer.parseInt(from[1]), Integer.parseInt(from[2]));
        LocalDate toDate = LocalDate.of(Integer.parseInt(to[0]), Integer.parseInt(to[1]), Integer.parseInt(to[2]));
        Booking booking = new Booking(true, fromDate, toDate, user.getId().intValue(), roomId);
        bookingService.save(booking);
        //System.out.println("Done!");
    }



}
