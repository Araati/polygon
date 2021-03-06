package com.araati.polygon.service;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.model.OwnerPayload;
import com.araati.polygon.repository.BlazonRepository;
import com.araati.polygon.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private BlazonRepository blazonRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public void addOwner(final OwnerPayload payload) {
        BlazonEntity blazon = blazonRepository.findByHash(payload.getHash());
        ownerRepository.save(new OwnerEntity(blazon.getId(),
                payload.getOwnerId(),
                payload.getOwnerPrefix()));
    }

    public OwnerEntity findOwnerByOwnerId(long ownerId)   {
        OwnerEntity owner = ownerRepository.findByOwnerId(ownerId);
        return owner;
    }

    public List<OwnerEntity> findOwnersByBlazonId(long blazonId)   {
        List<OwnerEntity> owners = ownerRepository.findAllByBlazonId(blazonId);
        return owners;
    }
}
