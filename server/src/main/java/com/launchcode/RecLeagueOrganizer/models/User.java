package com.launchcode.RecLeagueOrganizer.models;

public class User {

    private int id;
    private static int nextId = 1;

    private String name;
    private Integer UserAge;
    private SkillLevel skillLevel;

    //Initialize a unique ID.
    public User() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public User(String aName, Integer UserAge, SkillLevel aSkillLevel) {
        this();
        name = aName;
        age = UserAge;
        skillLevel = aSkillLevel;
    }


}
