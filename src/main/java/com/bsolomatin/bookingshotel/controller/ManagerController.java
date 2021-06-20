package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.*;
import com.bsolomatin.bookingshotel.repository.FeaturesRepository;
import com.bsolomatin.bookingshotel.repository.PhotosRepository;
import com.bsolomatin.bookingshotel.repository.RoomTypeRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.service.BookingService;
import com.bsolomatin.bookingshotel.service.FeatureService;
import com.bsolomatin.bookingshotel.service.RoomService;
import com.bsolomatin.bookingshotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
@PreAuthorize("hasAuthority('MANAGER')")
public class ManagerController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private BookingService bookingService;

//    @Autowired
//    private PhotosService photosService;

    @Autowired
    private FeatureService featureService;

    @PostMapping("features")
    public ResponseEntity<?> create(@ModelAttribute("feature")Feature feature) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("rooms")
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        //model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: rooms";
    }

    @GetMapping("room/{id}")
    public String getRoom(@PathVariable String id, Model model) {
        Room room = roomService.findById(Long.valueOf(id));
        model.addAttribute("room", room);
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: room";
    }

    @PostMapping("room")
    public String saveRoom(Model model, @RequestParam("roomId") Long id, @RequestParam("type") String type) {
        Room room = roomService.findById(id);
        room.setRoomType(roomTypeService.findById(Long.valueOf(type)));
        model.addAttribute("rooms", roomService.findAll());
        System.err.println("Mb to save or not");
        return "roomList :: rooms";
    }

    @GetMapping("bookings")
    public String getBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "roomList :: bookings";
    }

    @GetMapping("types")
    public String getTypes(Model model) {
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: types";
    }

    @GetMapping("type/{id}")
    public String getType(Model model, @PathVariable Long id) {
        RoomType roomType = roomTypeService.findById(Long.valueOf(id));
        model.addAttribute("type", roomType);
        model.addAttribute("features", featureService.findAll());
        return "roomList :: type";
    }

    @PostMapping("type")
    public String saveType(Model model, @ModelAttribute("roomType") RoomType roomType) {
        roomTypeService.save(roomType);
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: types";
    }
}
