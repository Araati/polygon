package com.araati.polygon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blazon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String owner, descr, hash;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Blazon() {
    }

    public Blazon(String owner, String descr, String hash) {
        this.owner = owner;
        this.descr = descr;
        this.hash = hash;
    }
}
