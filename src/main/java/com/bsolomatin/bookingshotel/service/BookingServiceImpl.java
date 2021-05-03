package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import org.joda.time.Interval;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Booking findById(Long id) {
        return bookingsRepository.getOne(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public void saveBooking(Booking booking) {
        List<Booking> list = bookingsRepository.findAll();
        list.stream().filter(item -> item.getRoomId() == booking.getRoomId());
        boolean flag = false;
        for(Booking booking1 : list) {
            if(booking1.getInterval().overlap(booking.getInterval()) != null) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            bookingsRepository.saveAndFlush(booking);
        } else {
            //TODO Exception
        }
    }

    @Override
    public void deleteById(Long id) {
        bookingsRepository.deleteById(id);

    }
}
