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

    @PostMapping("/events")
    public List<Event> searchEvents(@RequestBody Map<String, String> searchTerm) {
        System.out.println(searchTerm.get("searchTerm"));
        List<Event> searchResults = new ArrayList<Event>();
        for(Event event: eventRepository.findAll()) {
            if(event.getName().toLowerCase().contains(searchTerm.get("searchTerm").toLowerCase()) ||
                    event.getSkillLevel().toLowerCase().contains(searchTerm.get("searchTerm").toLowerCase()) ||
                    event.getLocation().toLowerCase().contains(searchTerm.get("searchTerm").toLowerCase()) ||
                    event.getEventType().toLowerCase().contains(searchTerm.get("searchTerm").toLowerCase()) ||
                    searchTerm.get("searchTerm").toLowerCase().contains(event.getName().toLowerCase()) ||
                    searchTerm.get("searchTerm").toLowerCase().contains(event.getSkillLevel().toLowerCase()) ||
                    searchTerm.get("searchTerm").toLowerCase().contains(event.getEventType().toLowerCase()) ||
                    searchTerm.get("searchTerm").toLowerCase().contains(event.getLocation().toLowerCase())){
                searchResults.add(event);
            }
        }
        return searchResults;
    }

}
