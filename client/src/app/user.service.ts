import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpParams } from '@angular/common/http';
import { Observable, throwError, Subject } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': '*',
    'Access-Control-Allow-Origin': '*'
  })
};


@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseURL: string = '//localhost:8080/';

  constructor(private http: HttpClient) { }

  registerUser(user: any): Observable<any>{
    let params = {email: user.email.toString(), username: user.username.toString(),
      password: user.password.toString()
    }
    return this.http.post(`${this.baseURL}addUser`, params, httpOptions)
  }

  userLogin(user: any): Observable<any>{
    let params = {email: user.email.toString(), password: user.password.toString()
    }
    return this.http.post(`${this.baseURL}userLogin`, params, httpOptions)
  }

  userlogout() {
    localStorage.setItem("userid", null);
    localStorage.removeItem("userid");
  }  
}

