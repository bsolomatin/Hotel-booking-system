package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Booking;
import java.util.List;

public interface BookingService {
    Booking findById(Long id);
    List<Booking> findAll();
    void saveBooking(Booking booking);
    void deleteById(Long id);
}
