package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
}
