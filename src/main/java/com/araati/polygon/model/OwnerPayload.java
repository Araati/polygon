package com.araati.polygon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OwnerPayload {

    /*
    http://localhost:8080/ownerAdd
    {
        "hash": "hash",
        "ownerId": 0,
        "ownerPrefix": "o"
    }
     */

    @JsonProperty(value = "hash", required = true)
    private String hash;

    @JsonProperty(value = "owner_id", required = true)
    private long ownerId;

    @JsonProperty(value = "owner_prefix", required = true)
    private String ownerPrefix;
}
