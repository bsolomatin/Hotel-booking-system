package com.bsolomatin.bookingshotel;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import com.bsolomatin.bookingshotel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookingsHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsHotelApplication.class, args);
    }
}
