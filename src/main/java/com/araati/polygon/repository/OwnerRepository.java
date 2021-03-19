package com.araati.polygon.repository;

import com.araati.polygon.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {

    OwnerEntity findByOwnerId(long ownerId);
    OwnerEntity findByBlazonId(long blazonId);
}
