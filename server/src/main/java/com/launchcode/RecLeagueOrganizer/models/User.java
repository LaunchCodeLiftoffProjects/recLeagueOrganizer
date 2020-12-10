package com.launchcode.RecLeagueOrganizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @NotNull
    private String username;
    private String password;
    private String email;

    @Id
    @GeneratedValue
    private int id;

    public User() {}

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}