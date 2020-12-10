package com.launchcode.RecLeagueOrganizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    //Initialize a unique ID.
    public AbstractEntity() {

    }

    // Initialize the id and value fields.
    public AbstractEntity(String name) {
        this();
        this.name = name;
    }

}
