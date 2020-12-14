package com.launchcode.RecLeagueOrganizer.controllers;

import com.launchcode.RecLeagueOrganizer.models.User;
import com.launchcode.RecLeagueOrganizer.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/addUser")
    public boolean registerUserToDatabase(@RequestBody Map<String, String> body) {
        try{
            User newUser = new User();
            newUser.setEmail(body.get("email"));
            newUser.setUsername(body.get("username"));
            newUser.setPassword(body.get("password"));
            userRepository.save(newUser);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    @PostMapping("/userLogin")
    public User verifyLogin(@RequestBody Map<String, String> body) {
        try{
            User user = userRepository.findByEmail(body.get("email")).get();
            return user;
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("add")
    public String displayAddRegistrationForm(Model model) {

        model.addAttribute(new User());
        return "add";

    }

}
