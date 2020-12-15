package com.launchcode.RecLeagueOrganizer.controllers;

import com.launchcode.RecLeagueOrganizer.models.Event;
import com.launchcode.RecLeagueOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin({"*"})
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/add-event")
    public boolean addPost(@RequestBody Map<String, String> body){
        boolean success=false;
        try{
            Event newEvent = new Event();
            newEvent.setName(body.get("name"));
            newEvent.setLocation(body.get("location"));
            newEvent.setTime(body.get("time"));
            newEvent.setSkillLevel(body.get("skillLevel"));
            newEvent.setEventType(body.get("activityType"));
            newEvent.setAgeLevel(body.get("ageLevel"));
            newEvent.setEquipmentRequired(true);
            eventRepository.save(newEvent);
            success=true;
        } catch (Exception e){
            success=false;
        }
        return success;
    }
}