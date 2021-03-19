package com.araati.polygon.entity;

import javax.persistence.*;

@Entity
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long blazonId, ownerId;
    private String ownerPrefix;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBlazonId() {
        return blazonId;
    }

    public void setBlazonId(long blazonId) {
        this.blazonId = blazonId;
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

    public OwnerEntity(long blazonId, long ownerId, String ownerPrefix) {
        this.blazonId = blazonId;
        this.ownerId = ownerId;
        this.ownerPrefix = ownerPrefix;
    }

    public OwnerEntity() {
    }
}
