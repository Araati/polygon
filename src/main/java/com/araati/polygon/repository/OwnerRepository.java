package com.araati.polygon.repository;

import com.araati.polygon.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {

    OwnerEntity findByOwnerId(long ownerId);
    List<OwnerEntity> findAllByBlazonId(long blazonId);
}
