package launchcode.RecLeagueOrganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.launchcode.RecLeagueOrganizer.Event;

import java.util.Map;


@RestController
@CrossOrigin({"*"})
public class EventController {

    @PostMapping("/add-event")
    public boolean addPost(@RequestBody Map<String, String> body){
        boolean success=false;
        try{
            newEvent = new Event();
            newEvent.setTitle(body.get("name"));
            newEvent.setDescription(body.get("location"));
            newEvent.setSnippet(body.get("time"));
            newEvent.setImageurl(body.get("skillLevel"));
            newEvent.setUid(body.get("activityType"));
            newEvent.setAuthor(body.get("ageLevel"));
            newEvent.setAuthor(body.get("equipment"));
            postRepository.save(newPost);
            success=true;
        } catch (Exception e){
            success=false;
        }
        return success;
    }

}
