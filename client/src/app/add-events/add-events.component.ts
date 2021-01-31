import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventsServiceService } from '../events-service.service';


@Component({
  selector: 'app-add-events',
  templateUrl: './add-events.component.html',
  styleUrls: ['./add-events.component.css']
})
export class AddEventsComponent implements OnInit {

  eventForm:FormGroup;

  constructor(private formBuilder: FormBuilder, private eventsService: EventsServiceService) { }

  form(){
    this.eventForm = this.formBuilder.group({
      name:[''],
      time:[''],
      location:[''],
      activityType:[''],
      ageLevel:[''],
      skillLevel:[''],
      numberPlayers:[''],
      equipment:['']
    })
  }
  

  ngOnInit() {
    this.form();  
  }

  savePost(eventForm){
    console.log(eventForm);
    this.eventsService.createEvent(eventForm).subscribe();
  }



}
