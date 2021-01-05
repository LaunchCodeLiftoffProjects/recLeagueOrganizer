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
            if(event.getName().contains(searchTerm.get("searchTerm")) ||
                    event.getSkillLevel().contains(searchTerm.get("searchTerm")) ||
                    event.getLocation().contains(searchTerm.get("searchTerm")) ||
                    event.getEventType().contains(searchTerm.get("searchTerm")) ||
                    searchTerm.get("searchTerm").contains(event.getName()) ||
                    searchTerm.get("searchTerm").contains(event.getSkillLevel()) ||
                    searchTerm.get("searchTerm").contains(event.getEventType()) ||
                    searchTerm.get("searchTerm").contains(event.getLocation())){
                searchResults.add(event);
            }
        }
        return searchResults;
    }

}
