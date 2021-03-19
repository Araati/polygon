package com.araati.polygon.facade;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.model.BlazonPayload;
import com.araati.polygon.model.OwnerPayload;
import com.araati.polygon.service.BlazonService;
import com.araati.polygon.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlazonFacade {

    @Autowired
    private BlazonService blazonService;
    @Autowired
    private OwnerService ownerService;

    public void create(final BlazonPayload payload) {
        blazonService.create(payload);
    }

    public void addOwner(final OwnerPayload ownerPayload) {
        ownerService.addOwner(ownerPayload);
    }

    public BlazonEntity findBlazonByOwnerId(long ownerId) {
        OwnerEntity owner = ownerService.findOwnerByOwnerId(ownerId);
        BlazonEntity blazon = blazonService.findBlazonByBlazonId(owner.getBlazonId());
        return blazon;
    }

    public BlazonEntity findBlazonByHash(String hash)   {
        BlazonEntity blazon = blazonService.findBlazonByHash(hash);
        return blazon;
    }
    public OwnerEntity findOwnerByBlazonId(long id)  {
        OwnerEntity owner = ownerService.findOwnerByBlazonId(id);
        return owner;
    }

    public OwnerEntity findOwnerByOwnerId(long ownerId) {
        OwnerEntity owner = ownerService.findOwnerByOwnerId(ownerId);
        return owner;
    }
}
