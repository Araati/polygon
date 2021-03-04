package com.araati.polygon.repo;

import com.araati.polygon.models.Blazon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlazonRepo extends CrudRepository<Blazon, Long> {
    Blazon findBlazonByOwnerOrDescrOrLongDescOrHashOrBase64(String owner, String descr, String longDesc, String hash, String base64);
}
