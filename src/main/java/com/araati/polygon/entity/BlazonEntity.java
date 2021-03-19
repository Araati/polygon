package com.araati.polygon.entity;

import javax.persistence.*;

@Entity
public class BlazonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description, hash;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BlazonEntity(String description, String hash) {
        this.description = description;
        this.hash = hash;
    }

    public BlazonEntity() {
    }
}
