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

    private String owner, descr, longDesc, hash, base64;

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

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Blazon() {
    }

    public Blazon(String owner, String descr, String longDesc, String hash, String base64) {
        this.owner = owner;
        this.descr = descr;
        this.longDesc = longDesc;
        this.hash = hash;
        this.base64 = base64;
    }
}
