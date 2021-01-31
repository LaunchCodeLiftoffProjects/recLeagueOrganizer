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
    public List<Event> searchEvents(@RequestBody Map <String, String> searchTerm) {
        System.out.println(searchTerm);
        List<Event> searchResults = new ArrayList<Event>();
        for(Event event: eventRepository.findAll()) {
            if(event.getName().toLowerCase().contains(searchTerm.get("searchT").toLowerCase()) ||
                    event.getSkillLevel().toLowerCase().contains(searchTerm.get("searchT").toLowerCase()) ||
                    event.getLocation().toLowerCase().contains(searchTerm.get("searchT").toLowerCase()) ||
                    event.getEventType().toLowerCase().contains(searchTerm.get("searchT").toLowerCase()) ||
                    searchTerm.get("searchT").toLowerCase().contains(event.getName().toLowerCase()) ||
                    searchTerm.get("searchT").toLowerCase().contains(event.getSkillLevel().toLowerCase()) ||
                    searchTerm.get("searchT").toLowerCase().contains(event.getEventType().toLowerCase()) ||
                    searchTerm.get("searchT").toLowerCase().contains(event.getLocation().toLowerCase()))
            {
                searchResults.add(event);
            }
        }
        return searchResults;
    }

}
