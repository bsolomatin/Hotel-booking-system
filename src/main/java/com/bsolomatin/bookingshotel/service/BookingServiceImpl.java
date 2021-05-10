package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Booking;
import com.bsolomatin.bookingshotel.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Booking findByBookId(Long id) {
        return bookingsRepository.findByBookingId(id);
    }

    @Override
    public void deleteById(Long id) {
        bookingsRepository.deleteById(id);

    }

    @Override
    public void save(Booking booking) {
        bookingsRepository.saveAndFlush(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public List<Booking> getReservationByRoom(int roomId) {
        return bookingsRepository.getReservationByRoom(roomId);
    }

    @Override
    public List<Booking> getReservationByUser(int userId) {
        return bookingsRepository.getReservationByUser(userId);
    }

    public boolean canReserve(Long id, LocalDate d1, LocalDate d2) {
        return bookingsRepository.bookingListById(id,d1,d2).size() == 0;
    }


}
