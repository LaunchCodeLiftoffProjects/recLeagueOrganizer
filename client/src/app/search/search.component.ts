import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { EventsServiceService } from '../events-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchTerm: any;
  events: any;

  constructor(private router: Router, private route: ActivatedRoute, private eventsService:EventsServiceService) { }


  ngOnInit() {
    this.searchTerm = this.route.snapshot.paramMap.get('searchTerm');
    console.log(this.searchTerm.toString());
    this.eventsService.search(this.searchTerm).subscribe(e=>{this.events=e;
    console.log(this.events);
    });
    // this.route.paramMap.subscribe(params => {
    //   this.searchTerm = String(params.get('searchTerm'));
    //   console.log(this.searchTerm.toString());
    // })
  }
}
