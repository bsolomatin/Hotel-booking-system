package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookingService {
    Booking findByBookId(Long id);
    void deleteById(Long id);
    List<Booking> findAll();
    List<Booking> getReservationByRoom(int roomId);
}
