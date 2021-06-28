package com.araati.polygon.service;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.model.BlazonPayload;
import com.araati.polygon.repository.BlazonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlazonService {

    @Autowired
    private BlazonRepository blazonRepository;

    public void create(final BlazonPayload payload) {
        blazonRepository.save(new BlazonEntity(payload.getDescription(), payload.getHash()));
    }

    public BlazonEntity findBlazonByBlazonId(long blazonId) {
        BlazonEntity blazon = blazonRepository.findById(blazonId);
        return blazon;
    }


    public List<BlazonEntity> findAll() {
        List<BlazonEntity> blazons = blazonRepository.findAll();
        return blazons;
    }
}
