package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Feature;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FeatureService {
    List<Feature> findAll();
    Feature findById(Long id);
    void saveFeature(Feature feature);
    void deleteById(Long id);
}
