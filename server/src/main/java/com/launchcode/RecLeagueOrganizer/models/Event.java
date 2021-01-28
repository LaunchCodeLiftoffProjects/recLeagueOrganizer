package com.launchcode.RecLeagueOrganizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;
    private String date;
    private String time;
    private int numberOfPlayers;
    private int score;
    private String eventType;
    private boolean isEquipmentRequired;
    private String ageLevel;
    private String skillLevel;

    @ManyToOne
    @NotNull(message = "User is required")
    private User user;

    public Event() {

    }

    public Event(String location, String date, String time, int numberOfPlayers, int score, String eventType, boolean isEquipmentRequired, String ageLevel, String skillLevel, User user) {
        this.location = location;
        this.date = date;
        this.time = time;
        this.numberOfPlayers = numberOfPlayers;
        this.score = score;
        this.eventType = eventType;
        this.isEquipmentRequired = isEquipmentRequired;
        this.ageLevel = ageLevel;
        this.skillLevel = skillLevel;
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public boolean isEquipmentRequired() {
        return isEquipmentRequired;
    }

    public void setEquipmentRequired(boolean equipmentRequired) {
        isEquipmentRequired = equipmentRequired;
    }

    public String getAgeLevel() {
        return ageLevel;
    }

    public void setAgeLevel(String ageLevel) {
        this.ageLevel = ageLevel;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }
}
