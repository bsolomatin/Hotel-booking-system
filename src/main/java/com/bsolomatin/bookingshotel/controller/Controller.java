package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("rooms")
    public List<Room> getRooms() {
        return roomService.findAll();
    }

    @GetMapping("bookings")
    public List<Booking> getBookings() {
        return bookingService.findAll();
    }

    @GetMapping("bookings/{id}")
    public String getOne(@PathVariable String id) {
        return bookingService.findByBookId(Long.valueOf(id)).toString();
    }

    @Autowired
    private BookingsRepository bookingsRepository;

}
