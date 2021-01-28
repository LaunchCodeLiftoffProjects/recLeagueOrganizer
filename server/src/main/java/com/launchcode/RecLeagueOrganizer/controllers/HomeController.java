
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
    public boolean registerUserToDatabase(@RequestBody Map<String, String> params) {
        try{
            User newUser = new User();
            newUser.setEmail(params.get("email"));
            newUser.setUsername(params.get("username"));
            newUser.setPassword(params.get("password"));
            userRepository.save(newUser);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    @PostMapping("/userLogin")
    public User verifyLogin(@RequestBody Map<String, String> params) {
        try{
            User user = userRepository.findByEmail(params.get("email")).get();
            if(user.getPassword().equals((params.get("password")))){
                return user;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("add")
    public String displayAddRegistrationForm(Model model) {

        model.addAttribute(new User());
        return "add";

    }

    @GetMapping("form")
    public String displayForm(Model model) {

        model.addAttribute(new User());
        return "form";

    }

}
