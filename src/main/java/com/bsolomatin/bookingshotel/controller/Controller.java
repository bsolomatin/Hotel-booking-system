package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.*;
import com.bsolomatin.bookingshotel.repository.RoomTypeRepository;
import com.bsolomatin.bookingshotel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;


    @PostMapping("search")
    public List<Room> getSearchResult(@RequestParam("cI") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
                                  @RequestParam("cO") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut) {
        List<Room> list = roomService.getRoomsByIdNotIn(checkIn, checkOut);
        if(list != null) return list;
        else return roomService.findAll();
    }

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
//    @PostMapping("block")
//    public void addNewReservation(HttpServletRequest request, @AuthenticationPrincipal User user) {
//        int roomId = Integer.parseInt(request.getParameter("roomId"));
//        String[] from = request.getParameter("from").split("-");
//        String[] to = request.getParameter("to").split("-" );
//        LocalDate fromDate = LocalDate.of(Integer.parseInt(from[0]), Integer.parseInt(from[1]), Integer.parseInt(from[2]));
//        LocalDate toDate = LocalDate.of(Integer.parseInt(to[0]), Integer.parseInt(to[1]), Integer.parseInt(to[2]));
//        Booking booking = new Booking(fromDate, toDate, user.getId().intValue(), roomId);
//        bookingService.save(booking);
//        System.out.println("Done!");
//    }



}
