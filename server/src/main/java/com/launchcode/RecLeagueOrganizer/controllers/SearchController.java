package com.launchcode.RecLeagueOrganizer.controllers;

import com.launchcode.RecLeagueOrganizer.models.Event;
import com.launchcode.RecLeagueOrganizer.models.User;
import com.launchcode.RecLeagueOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
@CrossOrigin({"*"})
public class SearchController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> searchEvents(@RequestBody String searchTerm) {
        System.out.println(searchTerm);
        List<Event> searchResults = new ArrayList<Event>();
        for(Event event: eventRepository.findAll()) {
            if(event.getName().contains(searchTerm) ||
                    event.getSkillLevel().contains(searchTerm) ||
                    event.getLocation().contains(searchTerm) ||
                    event.getEventType().contains(searchTerm) ||
                    searchTerm.contains(event.getName()) ||
                    searchTerm.contains(event.getSkillLevel()) ||
                    searchTerm.contains(event.getEventType()) ||
                    searchTerm.contains(event.getLocation())){
                searchResults.add(event);
            }
        }
        return searchResults;
    }

}
