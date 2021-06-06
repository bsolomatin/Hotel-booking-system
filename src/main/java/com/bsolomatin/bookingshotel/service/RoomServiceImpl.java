package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Room;
import com.bsolomatin.bookingshotel.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements  RoomService{

    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public Room findById(Long id) {
        return roomsRepository.getOne(id);
    }

    @Override
    public List<Room> findAll() {
        return roomsRepository.findAll();
    }

    @Override
    public Room saveRoom(Room room) {
        return roomsRepository.save(room);
    }

    @Override
    public void deleteById(Long id) {
        roomsRepository.deleteById(id);
    }

    @Override
    public List<Room> getRoomsByIdNotIn(LocalDate d1, LocalDate d2) {
        return roomsRepository.getRoomsByIdNotIn(d1, d2);
    }
}
