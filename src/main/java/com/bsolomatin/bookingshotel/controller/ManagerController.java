package com.bsolomatin.bookingshotel.controller;

import com.bsolomatin.bookingshotel.domain.*;
import com.bsolomatin.bookingshotel.repository.FeaturesRepository;
import com.bsolomatin.bookingshotel.repository.PhotosRepository;
import com.bsolomatin.bookingshotel.repository.RoomTypeRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

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

    @Autowired
    private PhotosService photosService;

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
    public String saveRoom(Model model, @ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        model.addAttribute("rooms", roomService.findAll());
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

    @GetMapping("types/add")
    public String addType(Model model) {
        model.addAttribute("type", new RoomType());
        model.addAttribute("features", featureService.findAll());
        return "roomList :: type";
    }

    @GetMapping("features/add")
    public String addFeatures(Model model) {
        model.addAttribute("feature", new Feature());
        return "roomList :: feature";
    }

    @GetMapping("rooms/add")
    public String addRooms(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: room";
    }

    @GetMapping("type/{id}")
    public String getType(Model model, @PathVariable Long id) {
        RoomType roomType = roomTypeService.findById(Long.valueOf(id));
        model.addAttribute("type", roomType);
        model.addAttribute("features", featureService.findAll());
        return "roomList :: type";
    }

    @PostMapping("type")
    public String saveType(Model model, @ModelAttribute("roomType") RoomType roomType) throws IOException {
        roomTypeService.save(roomType);
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: types";
    }

    @GetMapping("features")
    public String getFeatures(Model model) {
        model.addAttribute("features", featureService.findAll());
        return "roomList :: features";
    }

    @GetMapping("feature/{id}")
    public String getFeature(@PathVariable Long id, Model model) {
        Feature feature = featureService.findById(id);
        model.addAttribute("feature", feature);
        return "roomList :: feature";
    }

    @PostMapping("feature")
    public String saveFeature(Model model, @ModelAttribute("feature") Feature feature) {
        featureService.saveFeature(feature);
        model.addAttribute("features", featureService.findAll());
        return "roomList :: features";
    }

    @GetMapping("feature/del/{id}")
    public String delFeature(Model model, @PathVariable Long id) {
        List<RoomType> rt = roomTypeService.findAll();
        Feature f = featureService.findById(id);
        for(RoomType r : rt) {
            r.getFeatures().remove(f);
        }
        featureService.deleteById(id);
        model.addAttribute("features", featureService.findAll());
        return "roomList :: features";
    }

    @GetMapping("type/del/{id}")
    public String delType(Model model, @PathVariable Long id) {
        List<Room> rooms = roomService.findAll();
        RoomType r = roomTypeService.findById(id);
        for(Room room : rooms) {
            if(room.getRoomType() == r) roomService.deleteById(room.getId());
        }
        roomTypeService.deleteById(id);
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: types";
    }

    @GetMapping("room/del/{id}")
    public String delRoom(Model model, @PathVariable Long id) {
        roomService.deleteById(id);
        model.addAttribute("rooms", roomService.findAll());
        return "roomList :: rooms";
    }

    @GetMapping("photos")
    public String getForm(Model model) {
        model.addAttribute("types", roomTypeService.findAll());
        return "roomList :: photo";
    }

    @PostMapping("photos")
    public String savePhoto(@RequestParam("files") MultipartFile[] files, @RequestParam("selector") Long id) throws IOException {
        List<Photos> list = new LinkedList<>();
        RoomType roomType = roomTypeService.findById(id);
        for(MultipartFile file : files) {
            String str = new String(Base64.getEncoder().encodeToString(file.getBytes()));
            Photos photos = new Photos(str);
            photos.setRt(roomType);
            list.add(photos);
            photosService.save(photos);
        }
        roomType.setPhotos(list);
        roomTypeService.save(roomType);
        return "manager";
    }

    @GetMapping("bookings/{id}")
    public String deleteBookings(Model model, @PathVariable Long id) {
        bookingService.deleteById(id);
        model.addAttribute("bookings", bookingService.findAll());
        return "roomList :: bookings";
    }
}
