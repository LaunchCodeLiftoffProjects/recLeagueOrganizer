import { NgModule } from '@angular/core';
import { Routes, RouterModule, RouterLink } from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AddEventsComponent} from './add-events/add-events.component';
import {SearchComponent} from './search/search.component';
import {ProfileComponent} from './profile/profile.component';
import {HomeComponent} from './home/home.component';
import {ScoreboardComponent} from './scoreboard/scoreboard.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},                   
  {path: 'register', component: RegisterComponent},                      
  {path: 'add-events', component: AddEventsComponent},                      
  {path: 'search/:searchTerm', component: SearchComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'home', component: HomeComponent},
  {path: 'scoreboard', component: ScoreboardComponent},
  {path: '**', component: PageNotFoundComponent},
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
