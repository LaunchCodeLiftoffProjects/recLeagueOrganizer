import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpParams } from '@angular/common/http';
import { Observable, throwError, Subject } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
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
export class EventsServiceService {

  baseURL: string = '//localhost:8080/';

  constructor(private http: HttpClient) { }

  createEvent(event: any): Observable<any>{
    let params = {name: event.name.toString(), 
      time: event.time.toString(),
      location: event.location.toString(),
      activityType: event.activityType.toString(),
      ageLevel: event.ageLevel.toString(),
      skillLevel: event.skillLevel.toString(),
      numberPlayers: event.numberPlayers.toString(),
      equipment: event.equipment.toString(),
      userId: localStorage.getItem("userId")
    }
    return this.http.post(`${this.baseURL}add-event`, params, httpOptions);
              
  }

  search(searchTerm: string): Observable<any>{
    let params = {searchTerm: searchTerm.toString()
    }
    return this.http.post(`${this.baseURL}search/events`, params, httpOptions);
  }

}
