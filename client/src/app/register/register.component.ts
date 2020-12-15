import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder, } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userSaveForm: FormGroup; 
  constructor(private fb:FormBuilder, private userService:UserService) {

   }

   userForm(){
    this.userSaveForm=this.fb.group({
      username:[''],
      email:[''],
      password:[''],
      verify:[''],
    })
  }

  saveUser(newuser){
    if(newuser.password != newuser.verify){
      alert("Passwords do not match");
    } else {
    this.userService.registerUser(newuser).subscribe((e)=>{console.log(e)});
    console.log(newuser);
    }
  }

  ngOnInit() {
    this.userForm();
  }

}
