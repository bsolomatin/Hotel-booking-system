package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Photos;

import java.util.List;

public interface PhotosService {
    List<Photos> findAll();
    Photos findByImageBase64(String src);
    void save(Photos photos);
}
