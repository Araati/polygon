package com.araati.polygon.model;

public class BlazonPayload {
    private String description, hash;

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

    public BlazonPayload(String description, String hash) {
        this.description = description;
        this.hash = hash;
    }

    public BlazonPayload() {
    }
}
