package com.araati.polygon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BlazonPayload {
    /*
    http://localhost:8080/blazonAdd
    {
        "description": "description",
        "hash": "hash"
    }
     */

    private String description, hash;
}
