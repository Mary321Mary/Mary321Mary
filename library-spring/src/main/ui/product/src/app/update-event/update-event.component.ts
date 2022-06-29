import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Event, Employee } from '../service/http-client.service';

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {

  event: Event = new Event(-1, "", "", new Date);
  employees!: Employee[];

  constructor(
    private httpClientService:HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.findEventById().subscribe(
      response => {
        this.event = response.eventDto;
        this.employees = response.employees;
      },
    );
  }

  Submit() {
    if(this.event.id != -1){
      this.httpClientService.updateEvent(this.event).subscribe();
    } else {
      this.httpClientService.createEvent(this.event).subscribe();
    }
    this.router.navigate(['/evants']);
  }

}
