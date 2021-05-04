package com.bsolomatin.bookingshotel;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingsHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsHotelApplication.class, args);
    }

}
