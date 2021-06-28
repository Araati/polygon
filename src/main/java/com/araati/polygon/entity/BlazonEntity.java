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
public class BlazonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    @Column(unique = true)
    private String hash;

    public BlazonEntity(String description, String hash) {
        this.description = description;
        this.hash = hash;
    }

}
