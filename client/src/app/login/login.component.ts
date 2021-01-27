import { keyframes } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder, } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup; 
  constructor(private fb:FormBuilder, private userService:UserService) {

   }

   userForm(){
    this.loginForm=this.fb.group({
      email:[''],
      password:['']      
    })
  }

  loginUser(user){
    this.userService.userLogin(user).subscribe(
      e =>{
        if(!e){
          alert("Incorrect credentials, loser.")
        } else {
        localStorage.setItem("userId" , e.id);
      }
      });
 
  }

  logout(){
    this.userService.userlogout(); 
  }

  ngOnInit() {
    this.userForm();
  }

}
