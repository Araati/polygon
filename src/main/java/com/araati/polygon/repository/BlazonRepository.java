package com.araati.polygon.repository;

import com.araati.polygon.entity.BlazonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlazonRepository extends CrudRepository<BlazonEntity, Long> {
    BlazonEntity findByHash(String hash);
    BlazonEntity findById(long blazonId);
    List<BlazonEntity> findByDescriptionContains(String description);
    List<BlazonEntity> findAll();
}
