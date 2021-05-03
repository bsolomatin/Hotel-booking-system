package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {
    //List<Room> findAllRooms();
}
