package com.araati.polygon.repo;

import com.araati.polygon.models.Blazon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BlazonRepo extends CrudRepository<Blazon, Long> {
    Page<Blazon> findBlazonsByOwnerOrDescrContainsOrHash(String owner, String descr, String hash, Pageable pageable);
}
