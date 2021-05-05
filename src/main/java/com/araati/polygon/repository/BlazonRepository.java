package com.araati.polygon.repository;

import com.araati.polygon.entity.BlazonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlazonRepository extends CrudRepository<BlazonEntity, Long> {
    BlazonEntity findByHash(String hash);
    BlazonEntity findById(long blazonId);
    Page<BlazonEntity> findByDescriptionContains(String description, Pageable pageable);
    List<BlazonEntity> findAll();
}
