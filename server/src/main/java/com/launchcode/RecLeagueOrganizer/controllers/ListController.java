package launchcode.RecLeagueOrganizer.controllers;

import com.launchcode.RecLeagueOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    private EventRepository eventRepository;


}
