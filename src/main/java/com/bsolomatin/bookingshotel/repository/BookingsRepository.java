package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {
    @Query(value = "Select * From hotel.booking Where room_id=:id and (check_in, check_out) OVERLAPS (:d1, :d2)", nativeQuery = true)
    List<Booking> bookingListById(
            @Param("id") Long id,
            @Param("d1") LocalDate d1,
            @Param("d2") LocalDate d2);


    @Query(value = "Select * From hotel.booking Where room_id = :id", nativeQuery = true)
    List<Booking> getReservationByRoom(@Param("id") int id);

    @Query(value = "Select * From fin.booking Where user_id = :id", nativeQuery = true)
    List<Booking> getReservationByUser(@Param("id") int id);

}
