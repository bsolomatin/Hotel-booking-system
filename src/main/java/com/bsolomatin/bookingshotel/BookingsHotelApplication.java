package com.bsolomatin.bookingshotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.bsolomatin.bookingshotel")
@SpringBootApplication
public class BookingsHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsHotelApplication.class, args);
    }

}
