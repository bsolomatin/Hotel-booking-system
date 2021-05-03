package com.bsolomatin.bookingshotel;

import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookingsHotelApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookingsHotelApplication.class, args);
    }

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public void run(String... args) throws Exception {
        Room room = new Room(1, 2, 3);
        this.roomsRepository.save(room);
    }
}
