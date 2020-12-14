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
      (e)=>{
        if(e != null) {  
          if(e.password != user.password) {
            alert("Incorrect Credentials")
          } else {
            localStorage.setItem("userid", e.id);
            console.log(e.id);
          }       
        } else {
          alert("User does not exist")
        }
        console.log(e)
      });
    console.log(user)    
  }

  logout(){
    this.userService.userlogout(); 
  }

  ngOnInit() {
    this.userForm();
  }

}
