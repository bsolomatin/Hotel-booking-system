package com.bsolomatin.bookingshotel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomsRepository extends JpaRepository<Room, Long> {
    List<Room> findAllRooms();
}
