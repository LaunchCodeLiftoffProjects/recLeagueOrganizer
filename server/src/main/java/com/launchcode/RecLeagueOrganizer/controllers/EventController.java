package com.launchcode.RecLeagueOrganizer.controllers;

import com.launchcode.RecLeagueOrganizer.models.Event;
import com.launchcode.RecLeagueOrganizer.models.data.EventRepository;
import com.launchcode.RecLeagueOrganizer.models.data.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add-event")
    public boolean addPost(@RequestBody Map<String, String> params){
        boolean success=false;
        try{
            Event newEvent = new Event();
            newEvent.setName(params.get("name"));
            newEvent.setLocation(params.get("location"));
            newEvent.setTime(params.get("time"));
            newEvent.setSkillLevel(params.get("skillLevel"));
            newEvent.setEventType(params.get("activityType"));
            newEvent.setAgeLevel(params.get("ageLevel"));
            newEvent.setEquipmentRequired(true);
            newEvent.setUser(userRepository.findById(Integer.parseInt(params.get("userId"))).get());
            eventRepository.save(newEvent);
            success=true;
        } catch (Exception e){
            success=false;
        }
        return success;
    }
}