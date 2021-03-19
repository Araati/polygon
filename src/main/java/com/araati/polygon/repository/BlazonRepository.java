package com.araati.polygon.repository;

import com.araati.polygon.entity.BlazonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BlazonRepository extends CrudRepository<BlazonEntity, Long> {
    //Page<BlazonEntity> findBlazonsByOwnerOrDescrContainsOrHash(String owner, String descr, String hash, Pageable pageable);
    BlazonEntity findByHash(String hash);
    BlazonEntity findById(long blazonId);
}
