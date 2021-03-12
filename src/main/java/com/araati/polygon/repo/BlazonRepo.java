package com.araati.polygon.repo;

import com.araati.polygon.models.Blazon;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BlazonRepo extends CrudRepository<Blazon, Long> {
    ArrayList<Blazon> findBlazonsByOwnerOrDescrContainsOrHash(String owner, String descr, String hash);
}
