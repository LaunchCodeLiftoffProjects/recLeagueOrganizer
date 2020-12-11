package com.launchcode.RecLeagueOrganizer.models.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.launchcode.RecLeagueOrganizer.models.Event;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
@CrossOrigin("*")
public interface EventRepository extends JpaRepository <Event,Integer> {

}