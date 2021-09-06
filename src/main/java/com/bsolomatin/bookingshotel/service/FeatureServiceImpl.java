package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.Feature;
import com.bsolomatin.bookingshotel.repository.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService{

    @Autowired
    private FeaturesRepository featuresRepository;

    @Override
    public List<Feature> findAll() {
        return featuresRepository.findAll();
    }

    @Override
    public Feature findById(Long id) {
        return featuresRepository.findById(id).get();
    }

    @Override
    public void saveFeature(Feature feature) {
        featuresRepository.saveAndFlush(feature);
    }

    @Override
    public void deleteById(Long id) {
        featuresRepository.deleteById(id);
    }
}
