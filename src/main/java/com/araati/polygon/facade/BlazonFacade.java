package com.araati.polygon.facade;

import com.araati.polygon.entity.BlazonEntity;
import com.araati.polygon.entity.OwnerEntity;
import com.araati.polygon.model.BlazonPayload;
import com.araati.polygon.model.OwnerPayload;
import com.araati.polygon.service.BlazonService;
import com.araati.polygon.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<OwnerEntity> findOwnersByBlazonId(long id)  {
        List<OwnerEntity> owners = ownerService.findOwnersByBlazonId(id);
        return owners;
    }

    public OwnerEntity findOwnerByOwnerId(long ownerId) {
        OwnerEntity owner = ownerService.findOwnerByOwnerId(ownerId);
        return owner;
    }

    public Page<BlazonEntity> paginated(String description, Pageable pageable)  {
        Page<BlazonEntity> page = blazonService.paginated(description, pageable);
        return page;
    }

    public List<BlazonEntity> findAll() {
        List<BlazonEntity> blazons = blazonService.findAll();
        return blazons;
    }

    public BlazonEntity findBlazonByBlazonId(long id)   {
        BlazonEntity blazon = blazonService.findBlazonByBlazonId(id);
        return blazon;
    }
}
