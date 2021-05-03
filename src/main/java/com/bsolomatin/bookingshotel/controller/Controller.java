package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private RoomService roomService;

    @GetMapping("rooms")
    public String getRooms() {
        roomService.findAll();
        return "";
    }

    @Autowired
    private BookingsRepository bookingsRepository;
}
