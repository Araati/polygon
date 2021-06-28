package com.araati.polygon.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long blazonId, ownerId;
    private String ownerPrefix;

    public OwnerEntity(long blazonId, long ownerId, String ownerPrefix) {
        this.blazonId = blazonId;
        this.ownerId = ownerId;
        this.ownerPrefix = ownerPrefix;
    }
}
