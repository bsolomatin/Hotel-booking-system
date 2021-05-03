package controllers;

import com.bsolomatin.bookingshotel.Room;
import com.bsolomatin.bookingshotel.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private RoomsRepository roomsRepository;

    @GetMapping("rooms")
    public List<Room> getRooms() {
        return this.roomsRepository.findAll();
    }
}
