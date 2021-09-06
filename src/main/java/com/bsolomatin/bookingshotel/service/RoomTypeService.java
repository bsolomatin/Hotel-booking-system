package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.RoomType;

import java.util.List;

public interface RoomTypeService {
    RoomType findById(Long id);
    List<RoomType> findAll();
    void save(RoomType roomType);
    void deleteById(Long id);
}
