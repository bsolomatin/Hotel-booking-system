package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Photos;
import com.bsolomatin.bookingshotel.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosServiceImpl implements PhotosService {

    @Autowired
    private PhotosRepository photosRepository;

    @Override
    public List<Photos> findAll() {
        return photosRepository.findAll();
    }

    @Override
    public Photos findByImageBase64(String src) {
        return photosRepository.findByImageBase64(src);
    }

    @Override
    public void save(Photos photos) {
        photosRepository.save(photos);
    }
}
