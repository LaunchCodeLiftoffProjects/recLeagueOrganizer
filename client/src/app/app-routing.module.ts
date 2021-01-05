import { NgModule } from '@angular/core';
import { Routes, RouterModule, RouterLink } from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AddEventsComponent} from './add-events/add-events.component';
import {SearchComponent} from './search/search.component';
import {ProfileComponent} from './profile/profile.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},                   
  {path: 'register', component: RegisterComponent},                      
  {path: 'add-events', component: AddEventsComponent},                      
  {path: 'search', component: SearchComponent},
  {path: 'profile', component: ProfileComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
