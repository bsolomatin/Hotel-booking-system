package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Room;

import java.util.List;

public interface RoomService {
    Room findById(Long id);
    List<Room> findAll();
    Room saveRoom(Room room);
    void deleteById(Long id);

}