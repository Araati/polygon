package com.araati.polygon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerPayload {
    @JsonProperty(value = "hash", required = true)
    private String hash;

    @JsonProperty(value = "owner_id", required = true)
    private long ownerId;

    @JsonProperty(value = "owner_prefix", required = true)
    private String ownerPrefix;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerPrefix() {
        return ownerPrefix;
    }

    public void setOwnerPrefix(String ownerPrefix) {
        this.ownerPrefix = ownerPrefix;
    }

    public OwnerPayload(String hash, long ownerId, String ownerPrefix) {
        this.hash = hash;
        this.ownerId = ownerId;
        this.ownerPrefix = ownerPrefix;
    }
}
