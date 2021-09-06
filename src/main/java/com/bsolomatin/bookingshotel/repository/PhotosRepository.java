package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
    Photos findByImageBase64(String src);
}
