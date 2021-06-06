package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {

    @Query(value = "Select * From test.room Where test.room.id NOT IN (Select room_id From test.booking Where (check_in, check_out) OVERLAPS (:d1, :d2))",nativeQuery = true)
    List<Room> getRoomsByIdNotIn(@Param("d1") LocalDate d1, @Param("d2") LocalDate d2);
}
