package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturesRepository extends JpaRepository<Feature, Long> {
    Feature findByDescription(String description);
}
