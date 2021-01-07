import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventsServiceService } from './events-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
<<<<<<< HEAD
<<<<<<< HEAD
  title = 'RecLeagueOrganizer';
=======
=======

>>>>>>> e3067dcd8845284de76f660bb51ccc339db43a46
  title = 'client';

  searchForm:FormGroup;

  constructor(private formBuilder: FormBuilder, private eventsService: EventsServiceService) { }

  form(){
    this.searchForm = this.formBuilder.group({
      searchTerm:['']
    });
  }

  ngOnInit() {
    this.form();  
  }

  search(searchForm){
    console.log(searchForm);
    this.eventsService.search(searchForm).subscribe((e)=>{console.log(e)});
  }

<<<<<<< HEAD
>>>>>>> dc6b44e6e5affd94361cd3a0aa3b388230f969c5
=======

>>>>>>> e3067dcd8845284de76f660bb51ccc339db43a46
}

