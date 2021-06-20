package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
