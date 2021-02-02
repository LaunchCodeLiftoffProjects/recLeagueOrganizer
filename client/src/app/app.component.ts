import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventsServiceService } from './events-service.service';
import { UserService } from './user.service';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  title = 'RecLeagueOrganizer';

  searchForm:FormGroup;
  loggedin:boolean;
  constructor(private userService:UserService, private router: Router, private formBuilder: FormBuilder, private eventsService: EventsServiceService) { }

  form(){
    this.searchForm = this.formBuilder.group({
      searchTerm:['']
    });
  }

  ngOnInit() {
    this.form();
    if(localStorage.getItem("userId")){
      this.loggedin=true;
    }
    else{
      this.loggedin=false;
    }
      
  }

  search(searchForm){
    console.log("1");
    console.log(searchForm);
    window.location.replace('/search/'+ this.searchForm.value.searchTerm);
  }


  logout(){
    this.userService.userlogout();
    window.location.replace('/home');
  }
}

