package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.RoomType;
import com.bsolomatin.bookingshotel.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType findById(Long id) {
        return roomTypeRepository.findById(id).get();
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void save(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

    @Override
    public void deleteById(Long id) {
        roomTypeRepository.deleteById(id);
    }
}
