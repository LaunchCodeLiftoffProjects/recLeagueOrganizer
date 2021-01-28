import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventsServiceService } from '../events-service.service';

@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.css']
})
export class ScoreboardComponent implements OnInit {

  score1Form:FormGroup;
  score2Form:FormGroup;
 
  teams: object[] = [
    {name: "Team A", photo: 'https://handlers.education.launchcode.org/static/images/sally-ride.jpg'},
    {name: "Team B", photo: 'https://handlers.education.launchcode.org/static/images/mae-jemison.jpg'},
    {name: "Team C", photo: 'https://handlers.education.launchcode.org/static/images/ellen-ochoa.jpg'}
  ];
  

  constructor(private formBuilder: FormBuilder, private eventsService: EventsServiceService) { }

  form1(){
    this.score1Form = this.formBuilder.group({
      score1:['']
     
    })
  }

  form2(){
    this.score2Form = this.formBuilder.group({
      score2:['']
      
    })
  }

  saveScore(scorerNumber, scoreValue){
     if(scorerNumber==1){
       console.log(scoreValue);
     } 
  }

    ngOnInit(): void {
    this.form1();
    this.form2();
  }

}
