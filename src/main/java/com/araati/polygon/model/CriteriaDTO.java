package com.araati.polygon.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CriteriaDTO {

    /*
    http://localhost:8080/criteria
    {
            "ownerId": null,
            "hash": "",
            "description": ""
    }
    */

    private long ownerId;
    private String hash;
    private String description;

    public long getOwnerId() {
        return ownerId;
    }

    public Optional<String> getHash() {
        return Optional.ofNullable(hash).filter(x -> !x.isBlank());
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description).filter(x -> !x.isBlank());
    }

}
